/*
 *
 */

package me.melvins.labs.exception.handling;

import me.melvins.labs.exception.RequestHeaderValidationException;
import me.melvins.labs.exception.UnknownException;
import me.melvins.labs.vo.RequestHeaderVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Mels
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RequestHeaderValidationException.class)
    public ResponseEntity<Object> handleUnknownException(RequestHeaderValidationException ex,
                                                         WebRequest webRequest) {

        Set<ConstraintViolation<RequestHeaderVO>> constraintViolations = ex.getConstraintViolations();

        for (ConstraintViolation<RequestHeaderVO> s: constraintViolations){
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        return handleExceptionInternal(ex, null, httpHeaders, BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = UnknownException.class)
    public ResponseEntity<Object> handleUnknownException(UnknownException ex, WebRequest webRequest) {

        HttpStatus httpStatus = ex.getHttpStatus();
        ErrorCode errorCode = ex.getErrorCode();

        Error error = new Error(errorCode.name(), errorCode.getMessage());

        HttpHeaders httpHeaders = new HttpHeaders();
        return handleExceptionInternal(ex, error, httpHeaders, httpStatus, webRequest);
    }

}