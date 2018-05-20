package by.kosha.dao.implementation;

import by.kosha.entity.Theme;

public final class ThemeDaoImpl extends BaseDaoImpl<Integer, Theme> {

    private static final ThemeDaoImpl INSTANCE = new ThemeDaoImpl();

    public static ThemeDaoImpl getInstance() {
        return INSTANCE;
    }

    protected ThemeDaoImpl() {
        super(Theme.class);
    }
}
