package by.kosha.dao.implementation;

import by.kosha.dao.logic.GeneralDao;
import by.kosha.entity.IdBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<PK extends Serializable, T extends IdBase<PK>> implements GeneralDao<PK, T> {

    private static final SessionFactory FACTORY = SessionBase.getFactory();

    private Class<T> clazz;

    protected BaseDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(T entity) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = FACTORY.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
            Root<T> root = criteriaQuery.from(clazz);
            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).list();
        }
    }

    @Override
    public T getById(PK id) {
        try (Session session = FACTORY.openSession()) {
            return session.find(clazz, id);
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }
}
