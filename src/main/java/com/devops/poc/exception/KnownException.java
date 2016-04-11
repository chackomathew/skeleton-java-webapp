/*
 *
 */

package com.devops.poc.exception;

import com.devops.poc.exception.handling.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author
 */
public class KnownException extends RuntimeException {

    private HttpStatus httpStatus;

    private ErrorCode errorCode;

    private String customMessage;

    private Exception ex;

    public KnownException(HttpStatus httpStatus, ErrorCode errorCode, String customMessage, Exception ex) {
        super(ex);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.customMessage = customMessage;
        this.ex = ex;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public Exception getException() {
        return ex;
    }
}
