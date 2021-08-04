
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "description",
    "posted",
    "completed",
    "new_balance",
    "value"
})
@Data
public class Details {

    @JsonProperty("type")
    public String type;
    @JsonProperty("description")
    public String description;
    @JsonProperty("posted")
    public String posted;
    @JsonProperty("completed")
    public String completed;
    @JsonProperty("new_balance")
    public NewBalance newBalance;
    @JsonProperty("value")
    public Value value;

}
