
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "holder",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank",
    "metadata"
})
@Data
public class OtherAccount {

    @JsonProperty("id")
    public String id;
    @JsonProperty("holder")
    public Holder_ holder;
    @JsonProperty("number")
    public String number;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("IBAN")
    public String iBAN;
    @JsonProperty("swift_bic")
    public String swiftBic;
    @JsonProperty("bank")
    public Bank_ bank;
    @JsonProperty("metadata")
    public Metadata metadata;

}
