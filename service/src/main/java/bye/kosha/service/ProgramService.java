package bye.kosha.service;

import bye.kosha.dao.entity.Program;
import bye.kosha.dao.repository.ProgramRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Service
@Transactional
public class ProgramService {

    private static final ProgramService INSTANCE = new ProgramService();
    private ProgramRepository programRepository;

    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> searchWithPagination(String name, String description, BigDecimal minPrice, BigDecimal maxPrice, int limit, int offset) {
        return programRepository.findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndPriceBetween(name, description, minPrice, maxPrice, PageRequest.of(offset, limit));
    }

    public static ProgramService getInstance() {
        return INSTANCE;
    }
}
