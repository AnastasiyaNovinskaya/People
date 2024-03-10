package Servlets;

import Model.Person;
import Repository.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeletePersonServlet", value = "/deletePerson")
public class DeletePersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Repository repository = new Repository();
        repository.deletePerson(id);

        HttpSession session = request.getSession(true);
        ArrayList<Person> peopleList = repository.getPeople();
        session.setAttribute("people", peopleList);

        response.sendRedirect("viewPeople.jsp");
    }
}
