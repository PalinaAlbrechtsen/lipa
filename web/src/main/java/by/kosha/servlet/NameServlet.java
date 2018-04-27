package by.kosha.servlet;

import by.kosha.service.NameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hej")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", NameService.getInstance().getName());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/hej.jsp")
                .forward(req, resp);
    }
}
