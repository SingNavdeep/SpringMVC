package com.study.spring.mvc.recipes.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService
{
	private final RecipeRepository recRep;
	
	public RecipeServiceImpl(RecipeRepository recRep)
	{
		this.recRep = recRep;
	}
	@Override
	public Set<Recipe> getRecipes()
	{
		Set<Recipe> recipes = new HashSet<>();
		recRep.findAll().iterator().forEachRemaining(recipes::add);
		
		return recipes;
	}
	@Override
	public Recipe findById(Long id)
	{
		Recipe aRecipe = null;
		Optional<Recipe> recipe = recRep.findById(id);
		
		if(recipe.isPresent())
		{
			aRecipe = recipe.get();
		}
		return aRecipe;
	}
	
}
