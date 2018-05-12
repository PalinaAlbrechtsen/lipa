package by.kosha.dao;

import by.kosha.entity.Country;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountryDao {

    private static final CountryDao INSTANCE = new CountryDao();
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public Country getById(Long id) {
        Country fSub;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            fSub = session.find(Country.class, id);
            session.getTransaction().commit();
        }
        return fSub;
    }

    public static CountryDao getInstance() {
        return INSTANCE;
    }
}
