
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "national_identifier",
    "name"
})
@Data
public class Bank {

    @JsonProperty("national_identifier")
    public String nationalIdentifier;
    @JsonProperty("name")
    public String name;

}
