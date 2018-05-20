package by.kosha.dao.implementation;

import by.kosha.dao.SessionBase;
import by.kosha.dao.logic.PurchaseDao;
import by.kosha.entity.Purchase;
import by.kosha.entity.QProgram;
import by.kosha.entity.QPurchase;
import by.kosha.entity.QSubscriber;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public final class PurchaseDaoImpl extends BaseDaoImpl<Long, Purchase> implements PurchaseDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final PurchaseDaoImpl INSTANCE = new PurchaseDaoImpl();

    protected PurchaseDaoImpl() {
        super(Purchase.class);
    }

    @Override
    public List<Purchase> getBySubscriberId(Long id) {
        try (Session session = FACTORY.openSession()) {
            QSubscriber subscriber = QSubscriber.subscriber;
            QPurchase purchase = QPurchase.purchase;
            return new JPAQuery<Purchase>(session)
                    .select(purchase)
                    .from(purchase)
                    .join(purchase.subscriber, subscriber)
                    .on(subscriber.id.eq(id))
                    .fetch();
        }
    }

    @Override
    public List<Purchase> getByProgramId(Integer id) {
        try (Session session = FACTORY.openSession()) {
            QProgram program = QProgram.program;
            QPurchase purchase = QPurchase.purchase;
            return new JPAQuery<Purchase>(session)
                    .select(purchase)
                    .from(purchase)
                    .join(purchase.program, program)
                    .on(program.id.eq(id))
                    .fetch();
        }
    }

    public static PurchaseDaoImpl getInstance() {
        return INSTANCE;
    }
}
