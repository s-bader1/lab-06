package com.example.code;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Constructs a City with a name and province/state.
     * @param city city name
     * @param province province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**gets city's name
     * @return the city's name */
    public String getCity() {
        return city;
    }
    /**
     * gets province's name
     * @return the province's name */
    public String getProvince() {
        return province;
    }


    /**
     * Compares this city to another object by city name only.
     * @param o the object to compare to; must be a  City
     * @return a negative integer, zero, or a positive integer depnding on how it comspres
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }


    /**
     * compares actual city and provinces (not the objects rather the actual cities
     * @param o the object to check if city is equal to
     * @return true if teh cities are the same, else false.
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City c = (City) o;
        return this.city.equals(c.city) && this.province.equals(c.province);
    }


    /**
     * used to optimize performace when comparing objects
     * @return a unique i for each city created.
     * */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    @Override
    public String toString() {
        return city + ", " + province;
    }


}

