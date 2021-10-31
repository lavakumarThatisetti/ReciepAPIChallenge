package com.hackerearth.omnicell.service;


import com.hackerearth.omnicell.domain.Recipe;
import com.hackerearth.omnicell.domain.RecipeShowResource;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface RecipeService {

    Recipe saveRecipe(final Recipe recipe);

    Recipe getRecipe(Integer id);

    RecipeShowResource showRecipeImage(Integer id);

    List<Recipe> getAllRecipes();
}
