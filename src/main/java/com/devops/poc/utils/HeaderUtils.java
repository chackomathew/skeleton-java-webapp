/*
 *
 */

package com.devops.poc.utils;

import com.devops.poc.exception.RequestHeaderValidationException;
import com.devops.poc.pojo.vo.RequestHeaderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

import static com.devops.poc.utils.BeanUtils.fillBean;

/**
 * @author
 */
public class HeaderUtils {

    private static final Logger LOGGER = LogManager.getLogger(HeaderUtils.class,
            new MessageFormatMessageFactory());

    public static RequestHeaderVO transformRequestHeader(Map<String, Object> headers, Class clazz) {

        RequestHeaderVO requestHeaderVO = null;
        try {
            requestHeaderVO = (RequestHeaderVO) fillBean(headers, clazz);

        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.warn("Unable To Transform Request Headers");
        }

        return requestHeaderVO;
    }

    public static void validateRequestHeader(RequestHeaderVO requestHeaderVO) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RequestHeaderVO>> constraintViolations = validator.validate(requestHeaderVO);

        if (constraintViolations.toArray().length != 0) {
            String message = "Validation Errors In Request Header";
            throw new RequestHeaderValidationException(message, constraintViolations);
        }
    }

}
