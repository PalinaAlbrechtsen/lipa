package by.kosha.servlet;

import by.kosha.entity.Country;
import by.kosha.entity.Subscriber;
import by.kosha.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hej")
public class CountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Country country = CountryService.getInstance().getById(1L);
        req.setAttribute("name", country.getName());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/hej.jsp")
                .forward(req, resp);
    }
}
