package com.example.ingredientsApplication.service;

import com.example.ingredientsApplication.entity.Ingredient;
import com.example.ingredientsApplication.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientsRepository) {
        this.ingredientRepository = ingredientsRepository;
    }

    List<Ingredient> listIngredients = new ArrayList<>();

    @Autowired
    public List<Ingredient> getAllIngredients(){
        return ingredientRepository.findAll();
    }

    public Ingredient insertIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Optional<Ingredient> findForId(Long id){
        return ingredientRepository.findById(id);
    }

    public Ingredient updateIngredient ( Long id, Ingredient ingredient) throws IllegalAccessException{
        if(ingredientRepository.existsById(id)){
            ingredient.setId(id);
            return ingredientRepository.save(ingredient);
        }else{
            throw new IllegalAccessException("ingredient non trovato!");
        }
    }

    public void deleteIngredient( Long id ){
        ingredientRepository.deleteById(id);
    }
}
