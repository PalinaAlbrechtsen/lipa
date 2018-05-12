package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class ThemeTest extends SessionBaseClass<Theme> {

    Theme theme = new Theme("Cardio");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Theme").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveTesting() {
        checkSaving(theme);
    }

    @Test
    public void findTesting() {
        checkFinding(theme);
    }
}
