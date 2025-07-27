package org.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PizzasRequest {
    @JsonProperty("Pizzas")
    private List<PizzaItem> pizzas;
}