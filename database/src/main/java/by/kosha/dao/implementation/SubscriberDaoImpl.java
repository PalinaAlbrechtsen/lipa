package by.kosha.dao.implementation;

import by.kosha.dao.logic.SubscriberDao;
import by.kosha.entity.Gender;
import by.kosha.entity.QSubscriber;
import by.kosha.entity.Subscriber;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public final class SubscriberDaoImpl extends BaseDaoImpl<Long, Subscriber> implements SubscriberDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final SubscriberDaoImpl INSTANCE = new SubscriberDaoImpl();

    @Override
    public List<Subscriber> getByBirthDate() {
        try (Session session = FACTORY.openSession()) {
            QSubscriber subscriber = QSubscriber.subscriber;

            return new JPAQuery<Subscriber>(session)
                    .select(subscriber)
                    .from(subscriber)
                    .where(subscriber.dateOfBirth.eq(LocalDate.now()))
                    .fetch();
        }
    }

    @Override
    public List<Subscriber> getByGender(Gender gender) {
        try (Session session = FACTORY.openSession()) {
            QSubscriber subscriber = QSubscriber.subscriber;

            return new JPAQuery<Subscriber>(session)
                    .select(subscriber)
                    .from(subscriber)
                    .where(subscriber.gender.eq(gender))
                    .fetch();
        }
    }

    @Override
    public Subscriber getByUserId(Long id) {
        try (Session session = FACTORY.openSession()) {
            QSubscriber subscriber = QSubscriber.subscriber;

            return new JPAQuery<Subscriber>(session)
                    .select(subscriber)
                    .from(subscriber)
                    .where(subscriber.user.id.eq(id))
                    .fetchOne();
        }
    }

    public static SubscriberDaoImpl getInstance() {
        return INSTANCE;
    }

    protected SubscriberDaoImpl() {
        super(Subscriber.class);
    }
}
