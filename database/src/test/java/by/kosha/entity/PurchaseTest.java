package by.kosha.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

public class PurchaseTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    Subscriber subscriber = new Subscriber("Martsipan",
            Date.valueOf(LocalDate.now()),
            Gender.MALE,
            new Address("Belarus", "Minsk"));
    Program program = new Program("Blow mind", new BigDecimal("20.00"), "The best program");
    Purchase purchase = new Purchase(Date.valueOf(LocalDate.now()), subscriber, program);

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Purchase").executeUpdate();
            session.createQuery("delete from Program").executeUpdate();
            session.createQuery("delete from Subscriber").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void testSaving() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            Arrays.asList(subscriber, program, purchase).forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Test
    public void testFinding() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            Arrays.asList(subscriber, program).forEach(session::save);
            Serializable savedPurchase = session.save(purchase);
            Purchase foundPurchase = session.find(Purchase.class, savedPurchase);
            System.out.println(foundPurchase);
            session.getTransaction().commit();
        }
    }
}
