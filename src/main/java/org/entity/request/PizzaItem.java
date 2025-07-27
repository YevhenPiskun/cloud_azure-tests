package org.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PizzaItem {
    @JsonProperty("Ingredients")
    private List<String> ingredients;
    @JsonProperty("Name")
    private String name;
}