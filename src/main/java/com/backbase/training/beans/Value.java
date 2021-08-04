
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "amount"
})
@Data
public class Value {

    @JsonProperty("currency")
    public String currency;
    @JsonProperty("amount")
    public String amount;

}
