package by.kosha.dao.logic;

import by.kosha.entity.User;

public interface UserDao extends GeneralDao<Long, User> {

    User getByEmail(String email);

    User getBySubscriberId(Long id);
}
