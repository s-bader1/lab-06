package com.example.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void hasCity_trueWhenPresent_falseWhenAbsent() {
        CityList list = new CityList();
        City edm = new City("Edmonton", "AB");
        list.add(edm);

        assertTrue(list.hasCity(new City("Edmonton", "AB")));
        assertFalse(list.hasCity(new City("Calgary", "AB")));
    }

    @Test
    void delete_removesCity() {
        CityList list = new CityList();
        City edm = new City("Edmonton", "AB");
        list.add(edm);
        assertEquals(1, list.countCities());

        list.delete(new City("Edmonton", "AB"));
        assertEquals(0, list.countCities());
        assertFalse(list.hasCity(edm));
    }

    @Test
    void delete_throwsWhenAbsent() {
        CityList list = new CityList();
        assertThrows(NoSuchElementException.class,
                () -> list.delete(new City("Calgary", "AB")));
    }

    @Test
    void countCities_returnsSize() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Edmonton", "AB"));
        list.add(new City("Calgary", "AB"));
        assertEquals(2, list.countCities());
    }


}
