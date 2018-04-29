package by.kosha.service;

import by.kosha.dao.NameDao;
import by.kosha.entity.Name;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameService {

    private static final NameService INSTANCE = new NameService();

    public Name getName() {
        return new Name(NameDao.getInstance().getName());
    }

    public static NameService getInstance() {
        return INSTANCE;
    }
}
