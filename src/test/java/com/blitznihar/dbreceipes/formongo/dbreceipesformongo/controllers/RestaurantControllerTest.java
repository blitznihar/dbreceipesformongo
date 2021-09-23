package com.blitznihar.dbreceipes.formongo.dbreceipesformongo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.constants.ControllerConstants;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.AddressModel;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.RestaurantModel;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.services.RestaurantService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private RestaurantController restaurantController;
    
    @MockBean
    private RestaurantService restaurantService;

    @MockBean
    private List<RestaurantModel> mockRestaurantModels;

    private List<RestaurantModel> mockRestaurantModels(){
        List<RestaurantModel> result = new ArrayList<RestaurantModel>();
        result.add(new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225")));
        return result;
       }
       
    @Autowired
    private MockMvc mockMvc;
        
    @Test
    public void restaurantMongoControllerIsNotNull() throws Exception
    {
        assertThat(restaurantController).isNotNull();
    }

    @Test
    public void getRestaurantMongoControllerSuccess() throws Exception
    {
        //when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantService.getRestaurantsAll()).thenReturn(mockRestaurantModels);
        assertEquals(restaurantController.getRestaurantAll(), mockRestaurantModels);
    }
    @Test
    public void insertRestaurantMongoControllerSuccess() throws Exception
    {
        //when(mockRestaurantMongoRepository.findAll()).thenReturn(mockRestaurantModels);
        when(restaurantService.saveRestaurantsAll(mockRestaurantModels)).thenReturn(0);
        assertEquals(restaurantController.insertRestaurantAll(mockRestaurantModels()), 1);
    }
    @Test
    public void get_restaurantMongoController_Success() throws Exception
    {
        when(restaurantService.getRestaurantsAll()).thenReturn(mockRestaurantModels());

        mockMvc.perform(MockMvcRequestBuilders.get(ControllerConstants.RESTAURANT))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Wendys"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].cuisine").value("Hamburgers"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].borough").value("Brooklyn"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.street").value("Flatbush Avenue"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.building").value("469"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].address.zipcode").value("11225"));
    }

    @Test
    public void insertRestaurantAll() throws Exception {
        //when(mockRestaurantMongoRepository.saveAll(mockRestaurantModels)).thenReturn(mockRestaurantModels);
        when(restaurantService.saveRestaurantsAll(mockRestaurantModels)).thenReturn(0);
        mockMvc.perform(MockMvcRequestBuilders.get(ControllerConstants.RESTAURANT))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
    
}