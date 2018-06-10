package by.kosha.dao.implementation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SessionBase {

    private static SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getFactory() {
        return FACTORY;
    }
}
