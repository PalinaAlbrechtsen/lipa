package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class SubscriberTest extends SessionBaseClass<Subscriber> {

    Subscriber subscriber = new Subscriber("Martsipan",
            Date.valueOf(LocalDate.now()),
            Gender.MALE,
            new Address("Belarus", "Minsk"));

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Purchase").executeUpdate();
            session.createQuery("delete from Subscriber").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void savingTest() {
        checkSaving(subscriber);
    }

    @Test
    public void findingTest() {
        checkFinding(subscriber);
    }
}
