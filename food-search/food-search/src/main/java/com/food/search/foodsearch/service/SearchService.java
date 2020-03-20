package com.food.search.foodsearch.service;


import com.food.search.foodsearch.model.FoodItem;
import com.food.search.foodsearch.model.FoodItemDTO;
import com.food.search.foodsearch.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	DTOConversionService dtoConversionService;

	public List<FoodItemDTO> searchItems(String searchQuery){


		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(searchQuery));
		List<FoodItem> foodItemList = mongoOperations.find(query, FoodItem.class);

		System.out.println("okokokk");

		List<FoodItemDTO> foodItemDTOList = dtoConversionService.convertToDTO(foodItemList);

		return foodItemDTOList;

	}



	public List<FoodItemDTO> querycategory(String category){

		Query query = new Query().addCriteria(Criteria.where("category").is(category));
		List<FoodItem> foodItemList = mongoOperations.find(query, FoodItem.class);

		List<FoodItemDTO> foodItemDTOList = dtoConversionService.convertToDTO(foodItemList);

		return foodItemDTOList;

	}

}
