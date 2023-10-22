package com.example.ingredientsApplication.repository;

import com.example.ingredientsApplication.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

}
