package by.kosha.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public abstract class SessionBaseClass<T> {

    public static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public void checkFinding(T entity) {
        Class aClass = entity.getClass();
        try (Session session = FACTORY.openSession()) {
            Serializable savedEntity = session.save(entity);
            assertNotNull("Fail!", savedEntity);
            T foundEntity = (T) session.find(aClass, savedEntity);
            System.out.println(foundEntity);
        }
    }

    public void checkSaving(T entity) {
        try (Session session = FACTORY.openSession()) {
            Serializable savedEntity = session.save(entity);
            assertNotNull("Fail!", savedEntity);
        }
    }
}
