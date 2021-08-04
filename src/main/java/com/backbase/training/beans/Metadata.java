
package com.backbase.training.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "public_alias",
    "private_alias",
    "more_info",
    "URL",
    "image_URL",
    "open_corporates_URL",
    "corporate_location",
    "physical_location"
})
@Data
public class Metadata {

    @JsonProperty("public_alias")
    public String publicAlias;
    @JsonProperty("private_alias")
    public String privateAlias;
    @JsonProperty("more_info")
    public String moreInfo;
    @JsonProperty("URL")
    public String uRL;
    @JsonProperty("image_URL")
    public String imageURL;
    @JsonProperty("open_corporates_URL")
    public String openCorporatesURL;
    @JsonProperty("corporate_location")
    public String corporateLocation;
    @JsonProperty("physical_location")
    public String physicalLocation;

}
