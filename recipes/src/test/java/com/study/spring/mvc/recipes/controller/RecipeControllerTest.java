package com.study.spring.mvc.recipes.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.study.spring.mvc.recipes.controllers.RecipeController;
import com.study.spring.mvc.recipes.domain.Recipe;
import com.study.spring.mvc.recipes.service.RecipeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest extends TestCase
{
	@Mock
	private RecipeService recSer;
	
	@Mock
	private Model model;
	
	private RecipeController recCont;
	
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		recCont = new RecipeController(recSer);
	}
	
	@Test
	public void testGetRecipeByID() throws Exception
	{
		//given
		Recipe aRecipe = new Recipe();
		aRecipe.setId(1L);
		
		//when and then
		when(recSer.findById(1L)).thenReturn(aRecipe);
		
		String result = recCont.getRecipeByID(1+"", model);
		
		verify(model, times(1)).addAttribute("recipe", aRecipe);
		assertEquals("recipe/show", result);
		
		//spring's Mock MVC to perform HTTP get requests on the controller
		//and verify the results.
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recCont).build();
		mockMvc.perform(get("/recipe/show/1"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/show"));
	}
}
