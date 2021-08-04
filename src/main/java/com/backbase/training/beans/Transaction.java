
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "this_account",
    "other_account",
    "details",
    "metadata"
})
@Data
public class Transaction {

    @JsonProperty("id")
    public String id;
    @JsonProperty("this_account")
    public ThisAccount thisAccount;
    @JsonProperty("other_account")
    public OtherAccount otherAccount;
    @JsonProperty("details")
    public Details details;
    @JsonProperty("metadata")
    public Metadata_ metadata;

}
