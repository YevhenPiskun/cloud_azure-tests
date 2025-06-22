package org.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IngredientItem {

    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Name")
    private String name;
}