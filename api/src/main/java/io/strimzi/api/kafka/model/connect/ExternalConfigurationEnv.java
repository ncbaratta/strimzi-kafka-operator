/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model.connect;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.strimzi.crdgenerator.annotations.Description;
import io.sundr.builder.annotations.Buildable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Representation for environment variables which will be passed to Kafka Connect
 */
@Buildable(
        editableEnabled = false,
        generateBuilderPackage = false,
        builderPackage = "io.fabric8.kubernetes.api.builder"
)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ExternalConfigurationEnv implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private ExternalConfigurationEnvVarSource valueFrom;
    private Map<String, Object> additionalProperties = new HashMap<>(0);

    @Description("Name of the environment variable which will be passed to the Kafka Connect pods. " +
            "The name of the environment variable cannot start with `KAFKA_` or `STRIMZI_`.")
    @JsonProperty(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Description("Value of the environment variable which will be passed to the Kafka Connect pods. " +
            "It can be passed either as a reference to Secret or ConfigMap field. " +
            "The field has to specify exactly one Secret or ConfigMap.")
    @JsonProperty(required = true)
    public ExternalConfigurationEnvVarSource getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(ExternalConfigurationEnvVarSource valueFrom) {
        this.valueFrom = valueFrom;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

