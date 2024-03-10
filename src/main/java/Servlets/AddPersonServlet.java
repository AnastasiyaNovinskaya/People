package Servlets;

import Model.Person;
import Repository.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddPersonServlet", value = "/addPerson")
public class AddPersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        Person person = new Person(name, surname, age);

        Repository repository = new Repository();
        repository.addPerson(person);

        ArrayList<Person> peopleList = repository.getPeople();
        HttpSession session = request.getSession(true);
        session.setAttribute("people", peopleList);

        response.sendRedirect("viewPeople.jsp");
    }
}
