package com.hackerearth.omnicell;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerearth.omnicell.config.Properties;
import com.hackerearth.omnicell.domain.Recipe;
import com.hackerearth.omnicell.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class OmnicellApplication implements ApplicationRunner {

	@Autowired
	Properties properties;

	@Autowired
	RecipeRepository recipeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OmnicellApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("application starts");
		RestTemplate restTemplate = new RestTemplate();
		ArrayList recipeList = restTemplate.getForObject(properties.getApi().getRecipeApi(), ArrayList.class);
		assert recipeList != null;
		List<Recipe> recipes = new ObjectMapper().convertValue(recipeList, new TypeReference<List<Recipe>>(){});
		recipes.forEach(recipe -> {
			recipeRepository.save(recipe);
		});
		log.info("successfully saved in DB");
	}
}
