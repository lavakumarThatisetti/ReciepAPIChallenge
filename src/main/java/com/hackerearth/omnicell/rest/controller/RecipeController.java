package com.hackerearth.omnicell.rest.controller;


import com.hackerearth.omnicell.domain.Recipe;
import com.hackerearth.omnicell.domain.RecipeShowResource;
import com.hackerearth.omnicell.rest.resource.MessageResponse;
import com.hackerearth.omnicell.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/")
@RequiredArgsConstructor
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @PostMapping(produces = "application/json")
    public ResponseEntity<?> saveRecipe(@Valid @RequestBody Recipe recipe) {
        try {
            return ResponseEntity.ok(recipeService.saveRecipe(recipe));
        }catch (Exception e){

            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Recipe Name Already Present"));
        }
    }

    @GetMapping(produces = "application/json", value = "{id}")
    public ResponseEntity<Recipe> getRecipe(@NotBlank @PathVariable Integer id){

        return ResponseEntity.ok(recipeService.getRecipe(id));
    }

    @GetMapping(value = "{id}/show")
    public ResponseEntity<String> showRecipeImage(@NotBlank @PathVariable Integer id){

        return ResponseEntity.ok(recipeService.showRecipeImage(id).getImage());
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Recipe>> getAllRecipes(){

        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

}
