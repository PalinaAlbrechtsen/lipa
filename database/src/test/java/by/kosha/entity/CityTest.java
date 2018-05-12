package by.kosha.entity;

import org.junit.Test;

public class CityTest extends SessionBaseClass<City> {

    City city = new City("Copenhagen");

    @Test
    public void checkSavingCity() {
        checkSaving(city);
    }

    @Test
    public void checkFindingCity() {
        checkFinding(city);
    }
}
