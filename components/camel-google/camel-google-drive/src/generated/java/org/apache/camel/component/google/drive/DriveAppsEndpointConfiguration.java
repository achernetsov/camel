/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.google.drive;

import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.google.api.services.drive.Drive.Apps}.
 */
@ApiParams(apiName = "drive-apps", 
           description = "The apps collection of methods",
           apiMethods = {@ApiMethod(methodName = "get", description="Gets a specific app", signatures={"com.google.api.services.drive.Drive$Apps$Get get(String appId)"}), @ApiMethod(methodName = "list", description="Lists a user's installed apps", signatures={"com.google.api.services.drive.Drive$Apps$List list()"})}, aliases = {})
@UriParams
@Configurer(extended = true)
public final class DriveAppsEndpointConfiguration extends GoogleDriveConfiguration {
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "get", description="The ID of the app")})
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
