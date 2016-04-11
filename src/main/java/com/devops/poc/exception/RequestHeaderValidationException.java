/*
 *
 */

package com.devops.poc.exception;

import com.devops.poc.pojo.vo.RequestHeaderVO;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author
 */
public class RequestHeaderValidationException extends RuntimeException {

    private Set<ConstraintViolation<RequestHeaderVO>> constraintViolations;

    public RequestHeaderValidationException(String message,
                                            Set<ConstraintViolation<RequestHeaderVO>> constraintViolations) {
        super(message);
        this.constraintViolations = constraintViolations;
    }

    public Set<ConstraintViolation<RequestHeaderVO>> getConstraintViolations() {
        return constraintViolations;
    }

}
