package by.kosha.dao.implementation;

import by.kosha.entity.Country;

public final class CountryDaoImpl extends BaseDaoImpl<Long, Country> {

    private static final CountryDaoImpl INSTANCE = new CountryDaoImpl();

    private CountryDaoImpl() {
        super(Country.class);
    }

    public static CountryDaoImpl getInstance() {
        return INSTANCE;
    }
}
