package com.hackerearth.omnicell.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecipeList {
    private List<Recipe> recipeList;
}
