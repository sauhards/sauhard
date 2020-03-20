package com.food.search.foodsearch.controller;


import com.food.search.foodsearch.model.FoodItem;
import com.food.search.foodsearch.model.FoodItemDTO;
import com.food.search.foodsearch.service.FoodCRUDService;
import com.food.search.foodsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {


	@Autowired
	SearchService searchService;

	@Autowired
	FoodCRUDService foodCRUDServiceService;


	@GetMapping("/search")
	public List<FoodItemDTO> searchFoodItems(@RequestParam String query){

		List<FoodItemDTO> foodItems = searchService.searchItems(query);
		System.out.println("ljafdkjsnkjfnkjdngfdngfdgfdg");
		return foodItems;

	}


	@PostMapping("/add")
	public String addFoodItem(@RequestBody FoodItem foodItem){

		boolean result = foodCRUDServiceService.insertFood(foodItem);
		System.out.println("second" + foodItem);
		return "okok";

	}


	@GetMapping("/searchByCategory")
	public List<FoodItemDTO> searchByCategory(@RequestParam String category){

		List<FoodItemDTO> foodItemList = searchService.querycategory(category);
		System.out.println("second" + foodItemList);
		return foodItemList;

	}


}
