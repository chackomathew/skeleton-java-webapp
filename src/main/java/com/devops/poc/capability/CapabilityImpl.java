/*
 *
 */

package com.devops.poc.capability;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class CapabilityImpl implements Capability {

    private static final Logger LOGGER = LogManager.getLogger(CapabilityImpl.class,
            new MessageFormatMessageFactory());

    @Override
    public void process() {

    }
}
