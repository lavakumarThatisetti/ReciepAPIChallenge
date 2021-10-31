package com.hackerearth.omnicell.rest.assembler;


import com.hackerearth.omnicell.domain.Recipe;
import com.hackerearth.omnicell.domain.RecipeShowResource;


import org.springframework.stereotype.Component;


@Component
public class RecipeAssembler {
    public RecipeShowResource toRecipeShowResource(Recipe recipe){
        return RecipeShowResource.builder()
                .image(recipe.getImage())
                .build();
    }
}
