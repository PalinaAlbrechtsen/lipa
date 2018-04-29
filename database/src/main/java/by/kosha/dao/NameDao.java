package by.kosha.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameDao {

    private static final NameDao INSTANCE = new NameDao();
    private static final String NAME = "Martcipan";

    public String getName() {
        return NAME;
    }

    public static NameDao getInstance() {
        return INSTANCE;
    }
}
