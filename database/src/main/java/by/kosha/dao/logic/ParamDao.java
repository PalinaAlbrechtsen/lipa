package by.kosha.dao.logic;

import by.kosha.entity.Param;

import java.util.List;

public interface ParamDao extends GeneralDao<Long, Param> {

    List<Param> getBySibscriberId(Long id);
}
