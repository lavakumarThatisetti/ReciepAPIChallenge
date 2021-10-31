package com.hackerearth.omnicell.service.impl;


import com.hackerearth.omnicell.domain.Recipe;
import com.hackerearth.omnicell.domain.RecipeShowResource;
import com.hackerearth.omnicell.repository.RecipeRepository;
import com.hackerearth.omnicell.rest.assembler.RecipeAssembler;
import com.hackerearth.omnicell.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeAssembler recipeAssembler;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }

    @Override
    public RecipeShowResource showRecipeImage(Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.map(value -> recipeAssembler.toRecipeShowResource(value)).orElse(null);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
