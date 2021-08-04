
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "is_alias"
})
@Data
public class Holder {

    @JsonProperty("name")
    public String name;
    @JsonProperty("is_alias")
    public Boolean isAlias;

}
