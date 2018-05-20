package by.kosha.dao.logic;

import by.kosha.entity.Program;

import java.math.BigDecimal;
import java.util.List;

public interface ProgramDao extends GeneralDao<Integer, Program> {

    List<Program> findByThreeFields(String name, String description, BigDecimal minValue, BigDecimal maxValue,
                                    int limit, int offset);
}
