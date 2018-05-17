package by.kosha.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.Serializable;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public abstract class SessionBase {

    public static SessionFactory FACTORY;

    @BeforeClass
    public static void before() {
        FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    public void cleanBefore(String query) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery(query).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public <T extends IdBase<?>> void checkFinding(T entity) {
        Class aClass = entity.getClass();
        try (Session session = FACTORY.openSession()) {
            Serializable savedEntity = session.save(entity);
            assertNotNull("Fail!", savedEntity);
            T foundEntity = (T) session.find(aClass, savedEntity);
            System.out.println(foundEntity);
        }
    }

//    public void checkSaving(T entity) {
//        try (Session session = FACTORY.openSession()) {
//            Serializable savedEntity = session.save(entity);
//            assertNotNull("Fail!", savedEntity);
//        }
//    }

    public <T extends IdBase<?>> void checkSaving(T... entity) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            Arrays.asList(entity).forEach(it -> {
                session.persist(it);
                assertNotNull("Fail!", it.getId());
            });

            session.getTransaction().commit();
        }
    }
}
