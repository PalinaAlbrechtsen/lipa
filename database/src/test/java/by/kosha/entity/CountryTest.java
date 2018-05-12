package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class CountryTest extends SessionBaseClass<Country> {

    Country savingCountry = new Country("Belarus");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Country ").executeUpdate();
            session.getTransaction().commit();
        }
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
