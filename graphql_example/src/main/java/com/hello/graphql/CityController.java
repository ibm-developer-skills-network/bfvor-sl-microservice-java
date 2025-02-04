package com.hello.graphql;

import com.hello.graphql.City;
import com.hello.graphql.CityService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @QueryMapping
    public City city(@Argument String name) {
        return cityService.getCityByName(name);
    }

    @QueryMapping
    public List<City> cities(@Argument String state) {
        return state != null ? cityService.getCitiesByState(state) 
                           : cityService.getAllCities();
    }
}
