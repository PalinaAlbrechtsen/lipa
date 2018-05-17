package by.kosha.entity;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class PurchaseTest extends SessionBase {

    private Subscriber subscriber = new Subscriber("Martsipan",
            LocalDate.now(),
            Gender.MALE,
            new Address(1L, 1L));
    private Program program = new Program("Blow mind", new BigDecimal("20.00"), "The best program");
    private Purchase purchase = new Purchase(LocalDate.now(), subscriber, program);

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
    public void savingTest() {
        checkSaving(subscriber, program, purchase);
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
