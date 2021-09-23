package com.blitznihar.dbreceipes.formongo.dbreceipesformongo.services;

import java.util.List;

import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.RestaurantModel;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    public RestaurantRepository restaurantRepository;

    public List<RestaurantModel> getRestaurantsAll()
    {
        return restaurantRepository.findAll();
        
    }

    public int saveRestaurantsAll(List<RestaurantModel> restaurants)
    {
        return restaurantRepository.saveAll(restaurants).size();
    }
}
