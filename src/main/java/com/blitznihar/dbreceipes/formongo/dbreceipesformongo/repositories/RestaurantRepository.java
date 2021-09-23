package com.blitznihar.dbreceipes.formongo.dbreceipesformongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.RestaurantModel;
@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantModel, String> {
    
}
