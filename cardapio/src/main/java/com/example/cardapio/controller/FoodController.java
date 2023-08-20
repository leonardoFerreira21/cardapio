package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.cardapio.entity.Food;
import com.example.cardapio.entity.FoodRequestDTO;
import com.example.cardapio.repository.FoodRepository;
import com.example.cardapio.entity.FoodResponseDTO;

//Mapeamento da API rest

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("food")

public class FoodController {
	
	@Autowired
	private FoodRepository repository;
	
	
	
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data ) {
		Food foodData = new Food(data);
		repository.save(foodData);
		return;
	}
	
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		
		List<FoodResponseDTO> foodlist = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodlist;
	}
	
	

}
