package by.kosha.entity;

import org.junit.Before;
import org.junit.Test;

public class CountryTest extends SessionBase {

    private Country savingCountry = new Country("Belarus");

    @Before
    public void clean() {
        cleanBefore("delete from Country ");
    }

    @Test
    public void saveTest() {
        checkSaving(savingCountry);
    }

    @Test
    public void findTest() {
        checkFinding(savingCountry);
    }
}
