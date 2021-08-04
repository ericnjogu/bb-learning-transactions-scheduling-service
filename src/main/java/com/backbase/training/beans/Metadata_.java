
package com.backbase.training.beans;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "narrative",
    "comments",
    "tags",
    "images",
    "where"
})
@Data
public class Metadata_ {

    @JsonProperty("narrative")
    public String narrative;
    @JsonProperty("comments")
    public List<String> comments = null;
    @JsonProperty("tags")
    public List<String> tags = null;
    @JsonProperty("images")
    public List<String> images = null;
    @JsonProperty("where")
    public String where;

}
