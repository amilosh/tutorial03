package main.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "HelloAppEngine",
        urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().print("Hello, " + name);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");

        request.setAttribute("name", name);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}
