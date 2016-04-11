/*
 *
 */

package com.devops.poc.pojo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class DomainModel {

    @JsonProperty(value = "Identifiers")
    private Map<String, String> identifiers;

    public DomainModel() {
        identifiers = new HashMap<>();
    }

    public Map<String, String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public String toString() {
        return "DomainModel{" +
                "identifiers=" + identifiers +
                '}';
    }

}
