package by.kosha.service;

import by.kosha.dao.implementation.ProgramDaoImpl;
import by.kosha.entity.Program;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProgramService {

    private static final ProgramService INSTANCE = new ProgramService();

    public List<Program> findByAllFieldsWithPagination(String name, String description, BigDecimal minValue, BigDecimal maxValue,
                                                       int limit, int offset){
        return ProgramDaoImpl.getInstance().findByThreeFields(name, description, minValue, maxValue, limit, offset);
    }

    public List<Program> getAll(){
        return ProgramDaoImpl.getInstance().getAll();
    }

    public static ProgramService getInstance() {
        return INSTANCE;
    }
}
