package Servlets;

import Model.Person;
import Repository.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/getPersonById")
public class GetPersonByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        Repository repository= new Repository();
        Person person = repository.getPersonById(id);

        request.setAttribute("person", person);

        request.getRequestDispatcher("/updatePerson.jsp").forward(request, response);
    }
}
