package com.hello.graphql;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private List<City> cities;
    private final ObjectMapper objectMapper;

    public CityService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadCities() throws IOException {
        ClassPathResource resource = new ClassPathResource("UScities.json");
        cities = objectMapper.readValue(resource.getInputStream(), 
                     new TypeReference<List<City>>() {});
    }

    public City getCityByName(String name) {
        return cities.stream()
                .filter(city -> city.getCity().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<City> getCitiesByState(String state) {
        return cities.stream()
                .filter(city -> city.getState().equals(state))
                .collect(Collectors.toList());
    }

    public List<City> getAllCities() {
        return cities;
    }
}