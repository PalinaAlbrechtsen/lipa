package bye.kosha.servlet;

import bye.kosha.dao.entity.Program;
import bye.kosha.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/searchingProgram")
//@Controller
//@RequestMapping("/searchingProgram")
public class ProgramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/program-search.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        BigDecimal from = new BigDecimal(req.getParameter("from"));
        BigDecimal to = new BigDecimal(req.getParameter("to"));

        Integer limit = Integer.parseInt(req.getParameter("limit"));
        List<Program> foundProgs = ProgramService.getInstance()
                .searchWithPagination(name, description, from, to, limit, 0);
        req.setAttribute("programs", foundProgs);
        doGet(req, resp);
    }
}
