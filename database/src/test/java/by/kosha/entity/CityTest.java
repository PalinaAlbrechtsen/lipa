package by.kosha.entity;

import org.junit.Test;

public class CityTest extends SessionBase {

    private City city = new City("Copenhagen");

    @Test
    public void checkSavingCity() {
        checkSaving(city);
    }

    @Test
    public void checkFindingCity() {
        checkFinding(city);
    }
}
