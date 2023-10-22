package com.example.ingredientsApplication.controller;

import com.example.ingredientsApplication.entity.Ingredient;
import com.example.ingredientsApplication.service.IngredientService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/selectAll")
    public List<Ingredient> getAllIngredient (){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/selectbyId/{id}")
    public ResponseEntity<String> getIngredientById (@PathVariable Long id){
        Optional opt = ingredientService.findForId(id);
        if(opt.isPresent()){
            return ResponseEntity.ok("Ingredient trovato!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insertIngredient")
    public Ingredient createIngredient (@RequestBody Ingredient ingredient){
        return ingredientService.insertIngredient(ingredient);
    }

    @PutMapping("/updateIngredient/{id}")
    public Ingredient updateIngredient (@PathVariable Long id, @RequestBody Ingredient ingredient) throws IllegalAccessException {
        return ingredientService.updateIngredient(id,ingredient);
    }

    @DeleteMapping("/deleteIngredient/{id}")
    public void deleteIngredient (@PathVariable Long id){
        ingredientService.deleteIngredient(id);
    }
}
