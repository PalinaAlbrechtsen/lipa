package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class RoleTest extends SessionBaseClass<Role> {

    Role role = new Role("Admin");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Role").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void savingTest() {
        checkSaving(role);
    }

    @Test
    public void findingTest() {
        checkFinding(role);
    }
}
