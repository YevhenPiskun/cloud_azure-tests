package org.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IngredientsItem {

    @JsonProperty("Price")
    private int price;
    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Name")
    private String name;
}