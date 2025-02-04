package com.hello.graphql;

import java.util.Objects;

public class City {
    private String city;
    private String state;

    public City() {
    }

    public City(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && 
               Objects.equals(state, city1.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state);
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

