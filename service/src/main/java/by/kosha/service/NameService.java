package by.kosha.service;

import by.kosha.entity.Name;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameService {

    private static final NameService INSTANCE = new NameService();

    public Name getName() {
        return new Name("Martcipan");
    }

    public static NameService getInstance() {
        return INSTANCE;
    }
}
