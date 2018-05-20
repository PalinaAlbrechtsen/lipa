package by.kosha.dao.implementation;

import by.kosha.dao.SessionBase;
import by.kosha.dao.logic.ProgramDao;
import by.kosha.entity.Program;
import by.kosha.entity.Program_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public final class ProgramDaoImpl extends BaseDaoImpl<Integer, Program> implements ProgramDao {

    private static final SessionFactory FACTORY = SessionBase.getFactory();
    private static final ProgramDaoImpl INSTANCE = new ProgramDaoImpl();

    private ProgramDaoImpl() {
        super(Program.class);
    }

    @Override
    public List<Program> findByThreeFields(String name, String description, BigDecimal minValue, BigDecimal maxValue,
                                           int limit, int offset) {
        try (Session session = FACTORY.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Program> criteriaQuery = criteriaBuilder.createQuery(Program.class);
            Root<Program> root = criteriaQuery.from(Program.class);

            criteriaQuery.select(root)
                    .where(criteriaBuilder.and(criteriaBuilder.like(root.get(Program_.name), name),
                            criteriaBuilder.like(root.get(Program_.description), description),
                            criteriaBuilder.between(root.get(Program_.price), minValue, maxValue)));

            return session.createQuery(criteriaQuery).setFirstResult(offset).setMaxResults(limit).list();
        }
    }

    public static ProgramDaoImpl getInstance() {
        return INSTANCE;
    }
}
