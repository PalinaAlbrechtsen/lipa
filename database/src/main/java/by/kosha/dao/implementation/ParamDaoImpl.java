package by.kosha.dao.implementation;

import by.kosha.dao.SessionBase;
import by.kosha.dao.logic.ParamDao;
import by.kosha.entity.Param;
import by.kosha.entity.QParam;
import by.kosha.entity.QSubscriber;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class ParamDaoImpl extends BaseDaoImpl<Long, Param> implements ParamDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final ParamDaoImpl INSTANCE = new ParamDaoImpl();

    protected ParamDaoImpl() {
        super(Param.class);
    }

    @Override
    public List<Param> getBySibscriberId(Long id) {
        try (Session session = FACTORY.openSession()) {
            QParam param = QParam.param;
            QSubscriber subscriber = QSubscriber.subscriber;
            return new JPAQuery<Param>(session)
                    .select(param)
                    .from(param)
                    .join(param.subscriber, subscriber)
                    .on(subscriber.id.eq(id))
                    .fetch();
        }
    }

    public static ParamDaoImpl getInstance() {
        return INSTANCE;
    }
}
