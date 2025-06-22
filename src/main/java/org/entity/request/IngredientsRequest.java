package org.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class IngredientsRequest {

    @JsonProperty("Ingredients")
    private List<IngredientItem> ingredients;
}