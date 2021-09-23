package com.blitznihar.dbreceipes.formongo.dbreceipesformongo.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.RestaurantModel;
import com.blitznihar.dbreceipes.formongo.dbreceipesformongo.entities.AddressModel;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

//@Runwith(SpringRunner.class)
@DataMongoTest
public class RestaurantRepositoryTest {

@Autowired
private RestaurantRepository mongoRepository;


  @Test
  public void should_store_restaurants() throws Exception {

    RestaurantModel restaurantModel = new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225"));
    RestaurantModel restaurant = mongoRepository.save(restaurantModel);
    assertThat(restaurant).isNotNull();
    assertThat(restaurant).hasFieldOrPropertyWithValue("name","Wendys");
    assertThat(restaurant).hasFieldOrPropertyWithValue("cuisine","Hamburgers");
    assertThat(restaurant).hasFieldOrPropertyWithValue("borough","Brooklyn");
  }
  @Test
  public void should_store_all_restaurants() throws Exception {

    RestaurantModel restaurantModel = new RestaurantModel("Wendys","Hamburgers","Brooklyn",new AddressModel("Flatbush Avenue","469","11225"));
    List<RestaurantModel> restaurantModels = new ArrayList<RestaurantModel>();
    restaurantModels.add(restaurantModel);
    List<RestaurantModel> restaurants =  (List<RestaurantModel>) mongoRepository.saveAll(restaurantModels);
    assertThat(restaurants).isNotNull()
                            .hasSize(1)
                            .contains(restaurantModel);
    assertThat(restaurants.get(0)).hasFieldOrPropertyWithValue("name","Wendys")
                                .hasFieldOrPropertyWithValue("cuisine","Hamburgers")
                                .hasFieldOrPropertyWithValue("borough","Brooklyn");
  }
}
