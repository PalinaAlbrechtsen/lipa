package by.kosha.dao.implementation;

import by.kosha.entity.City;

public final class CityDaoImpl extends BaseDaoImpl<Long, City> {

    private static final CityDaoImpl INSTANCE = new CityDaoImpl();

    private CityDaoImpl() {
        super(City.class);
    }

    public static CityDaoImpl getInstance() {
        return INSTANCE;
    }
}
