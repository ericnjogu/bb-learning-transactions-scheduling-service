
package com.backbase.training.beans;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "holders",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank"
})
@Data
public class ThisAccount {

    @JsonProperty("id")
    public String id;
    @JsonProperty("holders")
    public List<Holder> holders = null;
    @JsonProperty("number")
    public String number;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("IBAN")
    public String iBAN;
    @JsonProperty("swift_bic")
    public String swiftBic;
    @JsonProperty("bank")
    public Bank bank;

}
