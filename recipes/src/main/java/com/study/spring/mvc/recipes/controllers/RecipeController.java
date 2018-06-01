package com.study.spring.mvc.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.mvc.recipes.service.RecipeService;

@Controller
public class RecipeController
{
	private final RecipeService recSer;
	
	//RecipeService autowired
	public RecipeController(RecipeService rSer)
	{
		this.recSer = rSer;
	}
	
	@RequestMapping("/recipe/show/{id}")
	public String getRecipeByID(@PathVariable String id, Model model)
	{
		model.addAttribute("recipe", recSer.findById(new Long(id)));
		
		return "recipe/show";
	}
}
