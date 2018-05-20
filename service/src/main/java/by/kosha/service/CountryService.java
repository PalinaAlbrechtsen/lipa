package by.kosha.service;

import by.kosha.dao.implementation.CountryDaoImpl;
import by.kosha.entity.Country;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountryService {

    private static final CountryService INSTANCE = new CountryService();

    public Country getById(Long id) {
        return CountryDaoImpl.getInstance().getById(id);
    }

    public static CountryService getInstance() {
        return INSTANCE;
    }
}
