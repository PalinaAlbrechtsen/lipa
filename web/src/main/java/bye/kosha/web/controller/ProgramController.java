package bye.kosha.web.controller;

import bye.kosha.entity.Program;
import bye.kosha.serviceImpl.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/searchingProgram")
    public String doGet(Model model) {
        Program program = new Program();
        model.addAttribute("program", program);
        model.addAttribute("programs", programService.getAll());

        return "program";
    }

    @PostMapping("/searchingProgram")
    public String doPost(Program program,
                         @RequestParam(value = "priceFrom", required = false)  String minPrice,
                         @RequestParam(value = "priceTo", required = false) String maxPrice,
                         @RequestParam(value = "limit", required = false) String limit,
                         Model model) {
        if (minPrice.equals("")){
            minPrice = "0";
        }
        if (maxPrice.equals("")){
            maxPrice = programService.getMaxPrice();
        }
        if (limit.equals("")){
            limit = "10";
        }
        model.addAttribute("programs", programService.searchWithPagination(program.getName(),
                program.getDescription(), new BigDecimal(minPrice), new BigDecimal(maxPrice), Integer.valueOf(limit), 0));

        return "program";
    }
}
