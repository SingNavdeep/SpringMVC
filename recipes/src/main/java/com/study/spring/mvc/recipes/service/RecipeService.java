package com.study.spring.mvc.recipes.service;

import java.util.Set;

import com.study.spring.mvc.recipes.domain.Recipe;

public interface RecipeService
{
	Set<Recipe> getRecipes();
}
