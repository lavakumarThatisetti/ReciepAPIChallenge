package com.hackerearth.omnicell.repository;

import com.hackerearth.omnicell.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

}
