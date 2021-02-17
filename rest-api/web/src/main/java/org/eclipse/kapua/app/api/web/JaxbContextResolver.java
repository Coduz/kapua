/*******************************************************************************
 * Copyright (c) 2016, 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.app.api.web;

import org.eclipse.kapua.app.api.core.exception.model.CleanJobDataExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceManagementRequestContentExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceManagementResponseCodeExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceManagementResponseContentExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceManagementSendExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceManagementTimeoutExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.DeviceNotConnectedExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.EntityNotFoundExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.ExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.IllegalArgumentExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.IllegalNullArgumentExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.InternalUserOnlyExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobAlreadyRunningExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobEngineExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobExecutionEnqueuedExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobInvalidTargetExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobMissingStepExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobMissingTargetExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobNotRunningExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobResumingExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobRunningExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobStartingExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.JobStoppingExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.MfaRequiredExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.SelfManagedOnlyExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.SubjectUnauthorizedExceptionInfo;
import org.eclipse.kapua.app.api.core.exception.model.ThrowableInfo;
import org.eclipse.kapua.app.api.core.model.CountResult;
import org.eclipse.kapua.app.api.core.model.StorableEntityId;
import org.eclipse.kapua.app.api.core.model.data.JsonDatastoreMessage;
import org.eclipse.kapua.app.api.core.model.data.JsonMessageQuery;
import org.eclipse.kapua.app.api.core.model.device.management.JsonGenericRequestMessage;
import org.eclipse.kapua.app.api.core.model.device.management.JsonGenericResponseMessage;
import org.eclipse.kapua.app.api.core.model.job.IsJobRunningMultipleResponse;
import org.eclipse.kapua.app.api.core.model.job.IsJobRunningResponse;
import org.eclipse.kapua.app.api.core.model.job.MultipleJobIdRequest;
import org.eclipse.kapua.app.api.core.model.message.JsonKapuaPayload;
import org.eclipse.kapua.app.api.resources.v1.resources.model.device.management.keystore.DeviceKeystoreCertificateInfo;
import org.eclipse.kapua.commons.service.event.store.api.EventStoreRecordCreator;
import org.eclipse.kapua.commons.service.event.store.api.EventStoreRecordListResult;
import org.eclipse.kapua.commons.service.event.store.api.EventStoreRecordQuery;
import org.eclipse.kapua.commons.service.event.store.api.EventStoreXmlFactory;
import org.eclipse.kapua.event.ServiceEvent;
import org.eclipse.kapua.job.engine.JobEngineXmlFactory;
import org.eclipse.kapua.job.engine.JobStartOptions;
import org.eclipse.kapua.message.device.data.KapuaDataChannel;
import org.eclipse.kapua.message.device.data.KapuaDataMessage;
import org.eclipse.kapua.message.device.data.KapuaDataPayload;
import org.eclipse.kapua.message.xml.MessageXmlRegistry;
import org.eclipse.kapua.model.config.metatype.KapuaTad;
import org.eclipse.kapua.model.config.metatype.KapuaTicon;
import org.eclipse.kapua.model.config.metatype.KapuaTmetadata;
import org.eclipse.kapua.model.config.metatype.KapuaTocd;
import org.eclipse.kapua.model.config.metatype.KapuaToption;
import org.eclipse.kapua.service.account.Account;
import org.eclipse.kapua.service.account.AccountCreator;
import org.eclipse.kapua.service.account.AccountListResult;
import org.eclipse.kapua.service.account.AccountQuery;
import org.eclipse.kapua.service.account.AccountXmlFactory;
import org.eclipse.kapua.service.authentication.ApiKeyCredentials;
import org.eclipse.kapua.service.authentication.AuthenticationCredentials;
import org.eclipse.kapua.service.authentication.AuthenticationXmlRegistry;
import org.eclipse.kapua.service.authentication.JwtCredentials;
import org.eclipse.kapua.service.authentication.RefreshTokenCredentials;
import org.eclipse.kapua.service.authentication.UsernamePasswordCredentials;
import org.eclipse.kapua.service.authentication.credential.Credential;
import org.eclipse.kapua.service.authentication.credential.CredentialCreator;
import org.eclipse.kapua.service.authentication.credential.CredentialListResult;
import org.eclipse.kapua.service.authentication.credential.CredentialQuery;
import org.eclipse.kapua.service.authentication.credential.CredentialType;
import org.eclipse.kapua.service.authentication.credential.CredentialXmlFactory;
import org.eclipse.kapua.service.authentication.credential.mfa.MfaOption;
import org.eclipse.kapua.service.authentication.credential.mfa.MfaOptionCreator;
import org.eclipse.kapua.service.authentication.credential.mfa.MfaOptionListResult;
import org.eclipse.kapua.service.authentication.credential.mfa.MfaOptionQuery;
import org.eclipse.kapua.service.authentication.credential.mfa.MfaOptionXmlFactory;
import org.eclipse.kapua.service.authentication.credential.mfa.ScratchCode;
import org.eclipse.kapua.service.authentication.credential.mfa.ScratchCodeCreator;
import org.eclipse.kapua.service.authentication.credential.mfa.ScratchCodeListResult;
import org.eclipse.kapua.service.authentication.credential.mfa.ScratchCodeQuery;
import org.eclipse.kapua.service.authentication.credential.mfa.ScratchCodeXmlFactory;
import org.eclipse.kapua.service.authentication.token.AccessToken;
import org.eclipse.kapua.service.authentication.token.LoginInfo;
import org.eclipse.kapua.service.authorization.access.AccessInfo;
import org.eclipse.kapua.service.authorization.access.AccessInfoCreator;
import org.eclipse.kapua.service.authorization.access.AccessInfoListResult;
import org.eclipse.kapua.service.authorization.access.AccessInfoQuery;
import org.eclipse.kapua.service.authorization.access.AccessInfoXmlFactory;
import org.eclipse.kapua.service.authorization.access.AccessPermission;
import org.eclipse.kapua.service.authorization.access.AccessPermissionCreator;
import org.eclipse.kapua.service.authorization.access.AccessPermissionListResult;
import org.eclipse.kapua.service.authorization.access.AccessPermissionQuery;
import org.eclipse.kapua.service.authorization.access.AccessPermissionXmlFactory;
import org.eclipse.kapua.service.authorization.access.AccessRole;
import org.eclipse.kapua.service.authorization.access.AccessRoleCreator;
import org.eclipse.kapua.service.authorization.access.AccessRoleListResult;
import org.eclipse.kapua.service.authorization.access.AccessRoleQuery;
import org.eclipse.kapua.service.authorization.access.AccessRoleXmlFactory;
import org.eclipse.kapua.service.authorization.domain.Domain;
import org.eclipse.kapua.service.authorization.domain.DomainListResult;
import org.eclipse.kapua.service.authorization.domain.DomainQuery;
import org.eclipse.kapua.service.authorization.domain.DomainXmlFactory;
import org.eclipse.kapua.service.authorization.group.Group;
import org.eclipse.kapua.service.authorization.group.GroupCreator;
import org.eclipse.kapua.service.authorization.group.GroupListResult;
import org.eclipse.kapua.service.authorization.group.GroupQuery;
import org.eclipse.kapua.service.authorization.group.GroupXmlFactory;
import org.eclipse.kapua.service.authorization.permission.Permission;
import org.eclipse.kapua.service.authorization.role.Role;
import org.eclipse.kapua.service.authorization.role.RoleCreator;
import org.eclipse.kapua.service.authorization.role.RoleListResult;
import org.eclipse.kapua.service.authorization.role.RolePermission;
import org.eclipse.kapua.service.authorization.role.RolePermissionCreator;
import org.eclipse.kapua.service.authorization.role.RolePermissionListResult;
import org.eclipse.kapua.service.authorization.role.RolePermissionQuery;
import org.eclipse.kapua.service.authorization.role.RolePermissionXmlFactory;
import org.eclipse.kapua.service.authorization.role.RoleQuery;
import org.eclipse.kapua.service.authorization.role.RoleXmlFactory;
import org.eclipse.kapua.service.config.ServiceComponentConfiguration;
import org.eclipse.kapua.service.config.ServiceConfiguration;
import org.eclipse.kapua.service.config.ServiceConfigurationXmlRegistry;
import org.eclipse.kapua.service.datastore.model.ChannelInfo;
import org.eclipse.kapua.service.datastore.model.ChannelInfoListResult;
import org.eclipse.kapua.service.datastore.model.ClientInfo;
import org.eclipse.kapua.service.datastore.model.ClientInfoListResult;
import org.eclipse.kapua.service.datastore.model.DatastoreMessage;
import org.eclipse.kapua.service.datastore.model.MessageListResult;
import org.eclipse.kapua.service.datastore.model.MetricInfo;
import org.eclipse.kapua.service.datastore.model.MetricInfoListResult;
import org.eclipse.kapua.service.datastore.model.query.ChannelInfoQuery;
import org.eclipse.kapua.service.datastore.model.query.ClientInfoQuery;
import org.eclipse.kapua.service.datastore.model.query.MessageQuery;
import org.eclipse.kapua.service.datastore.model.query.MetricInfoQuery;
import org.eclipse.kapua.service.datastore.model.xml.ChannelInfoXmlRegistry;
import org.eclipse.kapua.service.datastore.model.xml.ClientInfoXmlRegistry;
import org.eclipse.kapua.service.datastore.model.xml.DatastoreMessageXmlRegistry;
import org.eclipse.kapua.service.datastore.model.xml.MetricInfoXmlRegistry;
import org.eclipse.kapua.service.device.call.kura.model.bundle.KuraBundles;
import org.eclipse.kapua.service.device.call.kura.model.configuration.KuraDeviceConfiguration;
import org.eclipse.kapua.service.device.call.kura.model.deploy.KuraDeploymentPackage;
import org.eclipse.kapua.service.device.call.kura.model.deploy.KuraDeploymentPackages;
import org.eclipse.kapua.service.device.call.kura.model.inventory.KuraInventoryItem;
import org.eclipse.kapua.service.device.call.kura.model.inventory.KuraInventoryItems;
import org.eclipse.kapua.service.device.call.kura.model.inventory.bundles.KuraInventoryBundle;
import org.eclipse.kapua.service.device.call.kura.model.inventory.bundles.KuraInventoryBundles;
import org.eclipse.kapua.service.device.call.kura.model.inventory.packages.KuraInventoryPackage;
import org.eclipse.kapua.service.device.call.kura.model.inventory.packages.KuraInventoryPackages;
import org.eclipse.kapua.service.device.call.kura.model.inventory.system.KuraInventorySystemPackage;
import org.eclipse.kapua.service.device.call.kura.model.inventory.system.KuraInventorySystemPackages;
import org.eclipse.kapua.service.device.call.kura.model.snapshot.KuraSnapshotIds;
import org.eclipse.kapua.service.device.management.asset.DeviceAssetXmlRegistry;
import org.eclipse.kapua.service.device.management.asset.DeviceAssets;
import org.eclipse.kapua.service.device.management.bundle.DeviceBundle;
import org.eclipse.kapua.service.device.management.bundle.DeviceBundleXmlRegistry;
import org.eclipse.kapua.service.device.management.bundle.DeviceBundles;
import org.eclipse.kapua.service.device.management.command.DeviceCommandInput;
import org.eclipse.kapua.service.device.management.command.DeviceCommandOutput;
import org.eclipse.kapua.service.device.management.command.DeviceCommandXmlRegistry;
import org.eclipse.kapua.service.device.management.configuration.DeviceComponentConfiguration;
import org.eclipse.kapua.service.device.management.configuration.DeviceConfiguration;
import org.eclipse.kapua.service.device.management.configuration.DeviceConfigurationXmlRegistry;
import org.eclipse.kapua.service.device.management.inventory.model.bundle.inventory.DeviceInventoryBundle;
import org.eclipse.kapua.service.device.management.inventory.model.bundle.inventory.DeviceInventoryBundles;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.DeviceInventory;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.DeviceInventoryItem;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.DeviceInventoryXmlRegistry;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.packages.DeviceInventoryPackage;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.packages.DeviceInventoryPackages;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.system.DeviceInventorySystemPackage;
import org.eclipse.kapua.service.device.management.inventory.model.inventory.system.DeviceInventorySystemPackages;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystore;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreCSR;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreCSRInfo;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreCertificate;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreItem;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreItemQuery;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreItems;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreKeypair;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreXmlRegistry;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystores;
import org.eclipse.kapua.service.device.management.message.notification.OperationStatus;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestChannel;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestMessage;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestPayload;
import org.eclipse.kapua.service.device.management.message.request.xml.RequestMessageXmlRegistry;
import org.eclipse.kapua.service.device.management.message.response.KapuaResponseChannel;
import org.eclipse.kapua.service.device.management.message.response.KapuaResponseMessage;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackage;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackageBundleInfo;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackageBundleInfos;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackageXmlRegistry;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackages;
import org.eclipse.kapua.service.device.management.packages.model.download.DevicePackageDownloadOperation;
import org.eclipse.kapua.service.device.management.packages.model.download.DevicePackageDownloadRequest;
import org.eclipse.kapua.service.device.management.packages.model.install.DevicePackageInstallOperation;
import org.eclipse.kapua.service.device.management.packages.model.install.DevicePackageInstallRequest;
import org.eclipse.kapua.service.device.management.packages.model.uninstall.DevicePackageUninstallOperation;
import org.eclipse.kapua.service.device.management.packages.model.uninstall.DevicePackageUninstallRequest;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperation;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperationCreator;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperationListResult;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperationQuery;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperationXmlFactory;
import org.eclipse.kapua.service.device.management.registry.operation.notification.ManagementOperationNotification;
import org.eclipse.kapua.service.device.management.registry.operation.notification.ManagementOperationNotificationCreator;
import org.eclipse.kapua.service.device.management.registry.operation.notification.ManagementOperationNotificationListResult;
import org.eclipse.kapua.service.device.management.registry.operation.notification.ManagementOperationNotificationQuery;
import org.eclipse.kapua.service.device.management.registry.operation.notification.ManagementOperationNotificationXmlFactory;
import org.eclipse.kapua.service.device.management.request.GenericRequestXmlRegistry;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestChannel;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestMessage;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestPayload;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseChannel;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseMessage;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponsePayload;
import org.eclipse.kapua.service.device.management.snapshot.DeviceSnapshot;
import org.eclipse.kapua.service.device.management.snapshot.DeviceSnapshotXmlRegistry;
import org.eclipse.kapua.service.device.management.snapshot.DeviceSnapshots;
import org.eclipse.kapua.service.device.registry.Device;
import org.eclipse.kapua.service.device.registry.DeviceCreator;
import org.eclipse.kapua.service.device.registry.DeviceListResult;
import org.eclipse.kapua.service.device.registry.DeviceQuery;
import org.eclipse.kapua.service.device.registry.DeviceXmlFactory;
import org.eclipse.kapua.service.device.registry.connection.DeviceConnection;
import org.eclipse.kapua.service.device.registry.connection.DeviceConnectionListResult;
import org.eclipse.kapua.service.device.registry.connection.DeviceConnectionQuery;
import org.eclipse.kapua.service.device.registry.connection.DeviceConnectionXmlRegistry;
import org.eclipse.kapua.service.device.registry.connection.option.DeviceConnectionOption;
import org.eclipse.kapua.service.device.registry.connection.option.DeviceConnectionOptionXmlFactory;
import org.eclipse.kapua.service.device.registry.event.DeviceEvent;
import org.eclipse.kapua.service.device.registry.event.DeviceEventListResult;
import org.eclipse.kapua.service.device.registry.event.DeviceEventQuery;
import org.eclipse.kapua.service.device.registry.event.DeviceEventXmlFactory;
import org.eclipse.kapua.service.endpoint.EndpointInfo;
import org.eclipse.kapua.service.endpoint.EndpointInfoCreator;
import org.eclipse.kapua.service.endpoint.EndpointInfoListResult;
import org.eclipse.kapua.service.endpoint.EndpointInfoQuery;
import org.eclipse.kapua.service.endpoint.EndpointInfoXmlFactory;
import org.eclipse.kapua.service.endpoint.EndpointUsage;
import org.eclipse.kapua.service.job.Job;
import org.eclipse.kapua.service.job.JobCreator;
import org.eclipse.kapua.service.job.JobListResult;
import org.eclipse.kapua.service.job.JobQuery;
import org.eclipse.kapua.service.job.JobXmlFactory;
import org.eclipse.kapua.service.job.execution.JobExecution;
import org.eclipse.kapua.service.job.execution.JobExecutionListResult;
import org.eclipse.kapua.service.job.execution.JobExecutionQuery;
import org.eclipse.kapua.service.job.execution.JobExecutionXmlFactory;
import org.eclipse.kapua.service.job.step.JobStep;
import org.eclipse.kapua.service.job.step.JobStepCreator;
import org.eclipse.kapua.service.job.step.JobStepListResult;
import org.eclipse.kapua.service.job.step.JobStepQuery;
import org.eclipse.kapua.service.job.step.JobStepXmlFactory;
import org.eclipse.kapua.service.job.step.definition.JobStepDefinition;
import org.eclipse.kapua.service.job.step.definition.JobStepDefinitionListResult;
import org.eclipse.kapua.service.job.step.definition.JobStepDefinitionQuery;
import org.eclipse.kapua.service.job.step.definition.JobStepDefinitionXmlFactory;
import org.eclipse.kapua.service.job.step.definition.JobStepProperty;
import org.eclipse.kapua.service.job.targets.JobTarget;
import org.eclipse.kapua.service.job.targets.JobTargetCreator;
import org.eclipse.kapua.service.job.targets.JobTargetListResult;
import org.eclipse.kapua.service.job.targets.JobTargetQuery;
import org.eclipse.kapua.service.scheduler.trigger.Trigger;
import org.eclipse.kapua.service.scheduler.trigger.TriggerCreator;
import org.eclipse.kapua.service.scheduler.trigger.TriggerListResult;
import org.eclipse.kapua.service.scheduler.trigger.TriggerQuery;
import org.eclipse.kapua.service.scheduler.trigger.TriggerXmlFactory;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerDefinition;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerDefinitionListResult;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerDefinitionQuery;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerDefinitionXmlFactory;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerProperty;
import org.eclipse.kapua.service.scheduler.trigger.fired.FiredTrigger;
import org.eclipse.kapua.service.scheduler.trigger.fired.FiredTriggerListResult;
import org.eclipse.kapua.service.scheduler.trigger.fired.FiredTriggerQuery;
import org.eclipse.kapua.service.scheduler.trigger.fired.FiredTriggerXmlFactory;
import org.eclipse.kapua.service.storable.model.id.StorableId;
import org.eclipse.kapua.service.storable.model.query.SortField;
import org.eclipse.kapua.service.storable.model.query.SortFieldXmlAdapter;
import org.eclipse.kapua.service.storable.model.query.XmlAdaptedSortField;
import org.eclipse.kapua.service.storable.model.query.XmlAdaptedSortFields;
import org.eclipse.kapua.service.tag.Tag;
import org.eclipse.kapua.service.tag.TagCreator;
import org.eclipse.kapua.service.tag.TagListResult;
import org.eclipse.kapua.service.tag.TagQuery;
import org.eclipse.kapua.service.tag.TagXmlFactory;
import org.eclipse.kapua.service.user.User;
import org.eclipse.kapua.service.user.UserCreator;
import org.eclipse.kapua.service.user.UserListResult;
import org.eclipse.kapua.service.user.UserQuery;
import org.eclipse.kapua.service.user.UserXmlFactory;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Provide a customized JAXBContext that makes the concrete implementations
 * known and available for marshalling
 *
 * @since 1.0.0
 */
@Provider
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class JaxbContextResolver implements ContextResolver<JAXBContext> {

    private final JAXBContext jaxbContext;

    public JaxbContextResolver() {
        try {
            Map<String, Object> properties = new HashMap<>(1);
            properties.put(MarshallerProperties.JSON_WRAPPER_AS_ARRAY_NAME, true);

            jaxbContext = JAXBContextFactory.createContext(new Class[]{

                    // REST API utility models
                    CountResult.class,

                    // REST API exception models
                    ThrowableInfo.class,
                    ExceptionInfo.class,

                    InternalUserOnlyExceptionInfo.class,
                    SelfManagedOnlyExceptionInfo.class,
                    SubjectUnauthorizedExceptionInfo.class,

                    EntityNotFoundExceptionInfo.class,
                    IllegalArgumentExceptionInfo.class,
                    IllegalNullArgumentExceptionInfo.class,
                    MfaRequiredExceptionInfo.class,

                    // Jobs Exception Info
                    CleanJobDataExceptionInfo.class,
                    JobAlreadyRunningExceptionInfo.class,
                    JobEngineExceptionInfo.class,
                    JobExecutionEnqueuedExceptionInfo.class,
                    JobInvalidTargetExceptionInfo.class,
                    JobMissingStepExceptionInfo.class,
                    JobMissingTargetExceptionInfo.class,
                    JobNotRunningExceptionInfo.class,
                    JobResumingExceptionInfo.class,
                    JobRunningExceptionInfo.class,
                    JobStartingExceptionInfo.class,
                    JobStoppingExceptionInfo.class,

                    // Device Management Exception Info
                    DeviceManagementRequestContentExceptionInfo.class,
                    DeviceManagementResponseCodeExceptionInfo.class,
                    DeviceManagementResponseContentExceptionInfo.class,
                    DeviceManagementSendExceptionInfo.class,
                    DeviceManagementTimeoutExceptionInfo.class,
                    DeviceNotConnectedExceptionInfo.class,

                    // Tocds
                    KapuaTocd.class,
                    KapuaTad.class,
                    KapuaTicon.class,
                    KapuaTmetadata.class,
                    KapuaToption.class,

                    // Account
                    Account.class,
                    AccountCreator.class,
                    AccountListResult.class,
                    AccountQuery.class,
                    AccountXmlFactory.class,

                    // Data Channel Info
                    ChannelInfo.class,
                    ChannelInfoListResult.class,
                    ChannelInfoQuery.class,
                    ChannelInfoXmlRegistry.class,

                    // Data Client Info
                    ClientInfo.class,
                    ClientInfoListResult.class,
                    ClientInfoQuery.class,
                    ClientInfoXmlRegistry.class,

                    // Data Metric Info
                    MetricInfo.class,
                    MetricInfoListResult.class,
                    MetricInfoQuery.class,
                    MetricInfoXmlRegistry.class,

                    // Data Messages
                    KapuaDataMessage.class,
                    KapuaDataChannel.class,
                    KapuaDataPayload.class,

                    MessageListResult.class,
                    MessageQuery.class,
                    MessageXmlRegistry.class,

                    JsonKapuaPayload.class,
                    JsonDatastoreMessage.class,

                    DatastoreMessage.class,
                    DatastoreMessageXmlRegistry.class,
                    StorableEntityId.class,
                    StorableId.class,
                    SortField.class,
                    SortFieldXmlAdapter.class,
                    XmlAdaptedSortField.class,
                    XmlAdaptedSortFields.class,
                    JsonMessageQuery.class,

                    // Device
                    Device.class,
                    DeviceCreator.class,
                    DeviceListResult.class,
                    DeviceQuery.class,
                    DeviceXmlFactory.class,

                    // Device Connection
                    DeviceConnection.class,
                    DeviceConnectionListResult.class,
                    DeviceConnectionQuery.class,
                    DeviceConnectionXmlRegistry.class,

                    // Device Connection Options
                    DeviceConnectionOption.class,
                    DeviceConnectionOptionXmlFactory.class,

                    // Device Event
                    DeviceEvent.class,
                    DeviceEventListResult.class,
                    DeviceEventQuery.class,
                    DeviceEventXmlFactory.class,

                    // Device Management Assets
                    DeviceAssets.class,
                    DeviceAssetXmlRegistry.class,

                    // Device Management Bundles
                    KuraBundles.class,
                    DeviceBundle.class,
                    DeviceBundles.class,
                    DeviceBundleXmlRegistry.class,

                    // Device Management Command
                    DeviceCommandInput.class,
                    DeviceCommandOutput.class,
                    DeviceCommandXmlRegistry.class,

                    // Device Management Configuration
                    KuraDeviceConfiguration.class,
                    DeviceConfiguration.class,
                    DeviceComponentConfiguration.class,
                    DeviceConfigurationXmlRegistry.class,

                    // Device Management Inventory
                    DeviceInventory.class,
                    DeviceInventoryItem.class,
                    KuraInventoryItems.class,
                    KuraInventoryItem.class,
                    DeviceInventoryBundles.class,
                    DeviceInventoryBundle.class,
                    KuraInventoryBundles.class,
                    KuraInventoryBundle.class,
                    DeviceInventoryPackages.class,
                    DeviceInventoryPackage.class,
                    KuraInventoryPackages.class,
                    KuraInventoryPackage.class,
                    DeviceInventorySystemPackages.class,
                    DeviceInventorySystemPackage.class,
                    KuraInventorySystemPackages.class,
                    KuraInventorySystemPackage.class,
                    DeviceInventoryXmlRegistry.class,

                    // Device Management Keystore
                    DeviceKeystores.class,
                    DeviceKeystore.class,
                    DeviceKeystoreCertificateInfo.class,
                    DeviceKeystoreCertificate.class,
                    DeviceKeystoreItems.class,
                    DeviceKeystoreItem.class,
                    DeviceKeystoreItemQuery.class,
                    DeviceKeystoreCertificate.class,
                    DeviceKeystoreKeypair.class,
                    DeviceKeystoreCSRInfo.class,
                    DeviceKeystoreCSR.class,
                    DeviceKeystoreXmlRegistry.class,

                    // Device Management Snapshots
                    KuraSnapshotIds.class,
                    DeviceSnapshot.class,
                    DeviceSnapshots.class,
                    DeviceSnapshotXmlRegistry.class,

                    // Device Management Packages
                    KuraDeploymentPackages.class,
                    KuraDeploymentPackage.class,
                    DevicePackage.class,
                    DevicePackages.class,
                    DevicePackageBundleInfo.class,
                    DevicePackageBundleInfos.class,
                    DevicePackageDownloadRequest.class,
                    DevicePackageDownloadOperation.class,
                    DevicePackageInstallRequest.class,
                    DevicePackageInstallOperation.class,
                    DevicePackageUninstallRequest.class,
                    DevicePackageUninstallOperation.class,
                    DevicePackageXmlRegistry.class,

                    // Device Management Requests
                    KapuaRequestMessage.class,
                    KapuaResponseMessage.class,
                    KapuaRequestChannel.class,
                    KapuaResponseChannel.class,
                    KapuaRequestPayload.class,
                    RequestMessageXmlRegistry.class,

                    // Device Management Registry
                    DeviceManagementOperation.class,
                    DeviceManagementOperationCreator.class,
                    DeviceManagementOperationListResult.class,
                    DeviceManagementOperationQuery.class,
                    DeviceManagementOperationXmlFactory.class,
                    OperationStatus.class,

                    // Device Management Registry Notification
                    ManagementOperationNotification.class,
                    ManagementOperationNotificationCreator.class,
                    ManagementOperationNotificationListResult.class,
                    ManagementOperationNotificationQuery.class,
                    ManagementOperationNotificationXmlFactory.class,

                    // Device Management Generic Request
                    GenericRequestChannel.class,
                    GenericRequestPayload.class,
                    GenericRequestMessage.class,
                    GenericResponseChannel.class,
                    GenericResponsePayload.class,
                    GenericResponseMessage.class,
                    GenericRequestXmlRegistry.class,

                    JsonGenericRequestMessage.class,
                    JsonGenericResponseMessage.class,

                    // Authentication
                    AuthenticationCredentials.class,
                    AuthenticationXmlRegistry.class,
                    AccessToken.class,
                    LoginInfo.class,
                    ApiKeyCredentials.class,
                    JwtCredentials.class,
                    UsernamePasswordCredentials.class,
                    RefreshTokenCredentials.class,

                    // Credential
                    Credential.class,
                    CredentialListResult.class,
                    CredentialCreator.class,
                    CredentialType.class,
                    CredentialQuery.class,
                    CredentialXmlFactory.class,

                    // Multi Factor Authentication
                    MfaOption.class,
                    MfaOptionListResult.class,
                    MfaOptionCreator.class,
                    MfaOptionQuery.class,
                    MfaOptionXmlFactory.class,
                    ScratchCode.class,
                    ScratchCodeListResult.class,
                    ScratchCodeCreator.class,
                    ScratchCodeQuery.class,
                    ScratchCodeXmlFactory.class,

                    // Permission
                    Permission.class,

                    // Endpoint Info
                    EndpointUsage.class,
                    EndpointInfo.class,
                    EndpointInfoListResult.class,
                    EndpointInfoCreator.class,
                    EndpointInfoQuery.class,
                    EndpointInfoXmlFactory.class,

                    // Roles
                    Role.class,
                    RoleListResult.class,
                    RoleCreator.class,
                    RoleQuery.class,
                    RoleXmlFactory.class,

                    // Role Permissions
                    RolePermission.class,
                    RolePermissionListResult.class,
                    RolePermissionCreator.class,
                    RolePermissionQuery.class,
                    RolePermissionXmlFactory.class,

                    // Domains
                    Domain.class,
                    DomainListResult.class,
                    DomainQuery.class,
                    DomainXmlFactory.class,

                    // Groups
                    Group.class,
                    GroupListResult.class,
                    GroupCreator.class,
                    GroupQuery.class,
                    GroupXmlFactory.class,

                    // Access Info
                    AccessInfo.class,
                    AccessInfoListResult.class,
                    AccessInfoCreator.class,
                    AccessInfoQuery.class,
                    AccessInfoXmlFactory.class,

                    // Access Permissions
                    AccessPermission.class,
                    AccessPermissionListResult.class,
                    AccessPermissionCreator.class,
                    AccessPermissionQuery.class,
                    AccessPermissionXmlFactory.class,

                    // Access Roles
                    AccessRole.class,
                    AccessRoleListResult.class,
                    AccessRoleCreator.class,
                    AccessRoleQuery.class,
                    AccessRoleXmlFactory.class,

                    // Tag
                    Tag.class,
                    TagListResult.class,
                    TagCreator.class,
                    TagQuery.class,
                    TagXmlFactory.class,

                    // User
                    User.class,
                    UserCreator.class,
                    UserListResult.class,
                    UserQuery.class,
                    UserXmlFactory.class,

                    // KapuaEvent
                    ServiceEvent.class,
                    EventStoreRecordCreator.class,
                    EventStoreRecordListResult.class,
                    EventStoreRecordQuery.class,
                    EventStoreXmlFactory.class,

                    // Service Config
                    ServiceConfigurationXmlRegistry.class,
                    ServiceConfiguration.class,
                    ServiceComponentConfiguration.class,

                    // Jobs
                    Job.class,
                    JobStartOptions.class,
                    IsJobRunningResponse.class,
                    IsJobRunningMultipleResponse.class,
                    MultipleJobIdRequest.class,
                    JobCreator.class,
                    JobListResult.class,
                    JobQuery.class,
                    JobXmlFactory.class,

                    JobStartOptions.class,
                    IsJobRunningResponse.class,
                    JobEngineXmlFactory.class,

                    JobStep.class,
                    JobStepCreator.class,
                    JobStepListResult.class,
                    JobStepQuery.class,
                    JobStepXmlFactory.class,
                    JobStepProperty.class,

                    JobExecution.class,
                    JobExecutionListResult.class,
                    JobExecutionQuery.class,
                    JobExecutionXmlFactory.class,

                    JobTarget.class,
                    JobTargetCreator.class,
                    JobTargetListResult.class,
                    JobTargetQuery.class,
                    JobExecutionXmlFactory.class,

                    // Trigger
                    Trigger.class,
                    TriggerCreator.class,
                    TriggerListResult.class,
                    TriggerQuery.class,
                    TriggerProperty.class,
                    TriggerXmlFactory.class,

                    TriggerDefinition.class,
                    TriggerDefinitionListResult.class,
                    TriggerDefinitionQuery.class,
                    TriggerDefinitionXmlFactory.class,

                    FiredTrigger.class,
                    FiredTriggerListResult.class,
                    FiredTriggerQuery.class,
                    FiredTriggerXmlFactory.class,

                    JobStepDefinition.class,
                    JobStepDefinitionListResult.class,
                    JobStepDefinitionQuery.class,
                    JobStepDefinitionXmlFactory.class
            }, properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JAXBContext getContext(Class<?> type) {
        return jaxbContext;
    }

}
