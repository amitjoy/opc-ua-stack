package com.digitalpetri.opcua.stack.server.config;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.digitalpetri.opcua.stack.core.application.CertificateManager;
import com.digitalpetri.opcua.stack.core.channel.ChannelConfig;
import com.digitalpetri.opcua.stack.core.types.builtin.LocalizedText;
import com.digitalpetri.opcua.stack.core.types.structured.ApplicationDescription;
import com.digitalpetri.opcua.stack.core.types.structured.SignedSoftwareCertificate;
import com.digitalpetri.opcua.stack.core.types.structured.UserTokenPolicy;

public interface UaTcpStackServerConfig {

    /**
     * The server name to use when building endpoint URLs: "opc.tcp://{hostname}:{port}/{serverName}.".
     * <p>
     * If empty, endpoint URLs will be of the format "opc.tcp://{hostname}:{port}".
     *
     * @return the server name to use when building endpoint URLs.
     */
    String getServerName();

    /**
     * Get the application name for the server.
     * <p>
     * This will be used in the {@link ApplicationDescription} returned to clients.
     *
     * @return the application name for the server.
     */
    LocalizedText getApplicationName();

    /**
     * Get the application uri for the server.
     * <p>
     * This will be used in the {@link ApplicationDescription} returned to clients.
     * <p>
     * <b>The application uri must match the application uri used on the server's application instance certificate.</b>
     *
     * @return the application uri for the server.
     */
    String getApplicationUri();

    /**
     * Get the product uri for the server.
     * <p>
     * This will be used in the {@link ApplicationDescription} returned to clients.
     *
     * @return the product uri for the server.
     */
    String getProductUri();

    CertificateManager getCertificateManager();

    ExecutorService getExecutor();

    /**
     * Get the list of {@link UserTokenPolicy}s supported by the server.
     *
     * @return the list of {@link UserTokenPolicy}s supported by the server.
     */
    List<UserTokenPolicy> getUserTokenPolicies();

    List<SignedSoftwareCertificate> getSoftwareCertificates();

    ChannelConfig getChannelConfig();

    static UaTcpStackServerConfigBuilder builder() {
        return new UaTcpStackServerConfigBuilder();
    }

}