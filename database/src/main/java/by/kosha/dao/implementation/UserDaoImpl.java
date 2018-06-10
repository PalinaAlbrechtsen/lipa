package by.kosha.dao.implementation;

import by.kosha.dao.logic.UserDao;
import by.kosha.entity.QSubscriber;
import by.kosha.entity.QUser;
import by.kosha.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public final class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    @Override
    public User getByEmail(String email) {
        try (Session session = FACTORY.openSession()) {
            QUser user = QUser.user;

            return new JPAQuery<User>(session)
                    .select(user)
                    .from(user)
                    .where(user.email.eq(email))
                    .fetchOne();
        }
    }

    @Override
    public User getBySubscriberId(Long id) {
        try (Session session = FACTORY.openSession()) {
            QUser user = QUser.user;
            QSubscriber subscriber = QSubscriber.subscriber;

            return new JPAQuery<User>(session)
                    .select(user)
                    .from(user)
                    .join(user.subscriber, subscriber)
                    .fetchOne();
        }
    }

    protected UserDaoImpl() {
        super(User.class);
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }
}
