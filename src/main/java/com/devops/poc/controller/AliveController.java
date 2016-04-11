/*
 * 
 */

package com.devops.poc.controller;

import com.devops.poc.capability.Capability;
import com.devops.poc.exception.KnownException;
import com.devops.poc.exception.RequestHeaderValidationException;
import com.devops.poc.exception.UnknownException;
import com.devops.poc.exception.handling.ErrorCode;
import com.devops.poc.pojo.models.DomainModel;
import com.devops.poc.pojo.vo.RequestHeaderVO;
import com.devops.poc.pojo.vo.ResponseVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.devops.poc.utils.HeaderUtils.transformRequestHeader;
import static com.devops.poc.utils.HeaderUtils.validateRequestHeader;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author
 */
@RestController
@RequestMapping(value = "alive")
public class AliveController {

    @Autowired
    private Capability capabilityImpl;

    private static final Logger LOGGER = LogManager.getLogger(AliveController.class,
            new MessageFormatMessageFactory());

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<ResponseVO> testGet(@RequestHeader Map<String, Object> headers,
                                              @RequestParam(name = "check") String checker) {
        LOGGER.debug("Testing Alive");

        ResponseVO responseVO = null;
        try {
            RequestHeaderVO requestHeaderVO = transformRequestHeader(headers, RequestHeaderVO.class);

            validateRequestHeader(requestHeaderVO);

            List<String> strings = new ArrayList<>();
            strings.add("Is");
            strings.add("Alive");
            strings.add("With");
            strings.add(checker);

            responseVO = new ResponseVO();
            responseVO.setStringList(strings);

            capabilityImpl.process();

            // TODO transform Response Headers.

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public ResponseEntity<ResponseVO> testPost(@RequestHeader Map<String, String> headers,
                                               @RequestBody DomainModel domainModel) {

        ResponseVO responseVO = null;
        try {
            LOGGER.info("Is Alive");

            List<String> strings = new ArrayList<>();
            strings.add("Is");
            strings.add("Alive");

            LOGGER.debug("Request Body : {0}", domainModel);
            domainModel.getIdentifiers().forEach((k, v) -> {
                strings.add(k + " : " + v);
            });

            responseVO = new ResponseVO();
            responseVO.setStringList(strings);

        } catch (Exception ex) {
            handleExceptions(ex);
        }

        return new ResponseEntity<>(responseVO, null, HttpStatus.OK);
    }

    private void handleExceptions(Exception ex) {

        if (ex instanceof RequestHeaderValidationException) {
            throw (RequestHeaderValidationException) ex;

        } else if (ex instanceof KnownException) {
            throw (KnownException) ex;

        } else {
            ErrorCode errorCode = ErrorCode.EC1000;
            LOGGER.error(errorCode.toString(), ex);
            throw new UnknownException(INTERNAL_SERVER_ERROR, errorCode, ex);
        }
    }

}
