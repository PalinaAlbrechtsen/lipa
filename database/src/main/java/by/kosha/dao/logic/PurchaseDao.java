package by.kosha.dao.logic;

import by.kosha.entity.Purchase;

import java.util.List;

public interface PurchaseDao extends GeneralDao<Long, Purchase> {

    List<Purchase> getBySubscriberId(Long id);

    List<Purchase> getByProgramId(Integer id);
}
