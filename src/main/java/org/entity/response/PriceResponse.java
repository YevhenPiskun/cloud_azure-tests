package org.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PriceResponse {

    @JsonProperty("TotalPrice")
    private int totalPrice;
    @JsonProperty("Ingredients")
    private List<IngredientsItem> ingredients;
}