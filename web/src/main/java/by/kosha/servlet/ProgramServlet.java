package by.kosha.servlet;

import by.kosha.entity.Program;
import by.kosha.service.ProgramService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/searchProgram")
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
        Integer offset = Integer.parseInt(req.getParameter("offset"));
        Integer limit = Integer.parseInt(req.getParameter("limit"));
        List<Program> foundProgs = ProgramService.getInstance()
                .findByAllFieldsWithPagination(name, description, from, to, limit, offset);
        req.setAttribute("programs", foundProgs);
        doGet(req, resp);
    }
}
