package com.blitznihar.dbreceipes.formongo.dbreceipesformongo.services;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.RestaurantModel;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.repositories.RestaurantRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {


    @InjectMocks
    public RestaurantService restaurantService;

    @Mock
    public RestaurantRepository restaurantRepository;

    @Test
    void testGetRestaurantsAll() {
        List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
        when(restaurantRepository.findAll()).thenReturn(restaurants);
        assertThat(restaurantService.getRestaurantsAll()).isNotNull();
    }

    @Test
    void testSaveRestaurantsAll() {

        List<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
        when(restaurantRepository.saveAll(restaurants)).thenReturn(restaurants);
        assertThat(restaurantService.saveRestaurantsAll(restaurants)).isNotNull();
    }
}
