package com.study.spring.mvc.recipes.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.repositories.RecipeRepository;

/**
 *  A test case with Mockito
 * @author Navdeep
 *
 */
public class RecipeServiceImplTest extends TestCase
{
	private RecipeServiceImpl recipeSer;
	
	@Mock
	private RecipeRepository recipeRepo;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		recipeSer = new RecipeServiceImpl(recipeRepo);
	}
	
	@Test
	public void testGetRecipes()
	{
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		when(recipeSer.getRecipes()).thenReturn(recipes);
		
		Set<Recipe> mockRecipes = recipeSer.getRecipes();
		assertEquals(mockRecipes.size(), 1);
		
		verify(recipeRepo, times(1)).findAll();
	}
}
