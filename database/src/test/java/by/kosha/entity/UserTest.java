package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends SessionBaseClass<User> {

    User user = new User("email", "password");

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void savingTest() {
        checkSaving(user);
    }

    @Test
    public void findingTest() {
        checkFinding(user);
    }
}
