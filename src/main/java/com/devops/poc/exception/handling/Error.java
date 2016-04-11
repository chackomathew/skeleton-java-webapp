/*
 *
 */

package com.devops.poc.exception.handling;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author
 */
public class Error {

    @JsonProperty(value = "ErrorCode")
    private String errorCode;

    @JsonProperty(value = "ErrorMessage")
    private String errorMessage;

    public Error(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
