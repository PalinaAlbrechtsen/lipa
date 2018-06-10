package bye.kosha.serviceImpl;

import bye.kosha.entity.Program;
import bye.kosha.repository.ProgramRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> searchWithPagination(String name, String description, BigDecimal minPrice, BigDecimal maxPrice, int limit, int offset) {
        return programRepository.findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndPriceBetween(name, description, minPrice, maxPrice, PageRequest.of(offset, limit));
    }

    public List<Program> getAll(){
        return Lists.newArrayList(programRepository.findAll());
    }

    public String getMaxPrice(){
        return String.valueOf(programRepository.findMaxPrice());
    }
}
