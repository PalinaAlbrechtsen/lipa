package by.kosha.dao.logic;

import by.kosha.entity.IdBase;

import java.io.Serializable;
import java.util.List;

public interface GeneralDao<PK extends Serializable, T extends IdBase<PK>> {

    void save(T entity);

    void update(T entity);

    List<T> getAll();

    T getById(PK id);

    void delete(T entity);
}
