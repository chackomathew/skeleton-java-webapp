/*
 *
 */

package com.devops.poc.pojo.vo;

/**
 * @author
 */
public class RequestHeaderVO {

    private String correlationId;

    private String version;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
