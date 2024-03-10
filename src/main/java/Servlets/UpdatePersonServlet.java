package Servlets;

import Model.Person;
import Repository.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updatePerson")
public class UpdatePersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));

        Person updatedPerson = new Person(Integer.parseInt(id), name, surname, age);
        Repository repository= new Repository();
        repository.updatePerson(updatedPerson);

        ArrayList<Person> peopleList = repository.getPeople();
        HttpSession session = request.getSession(true);
        session.setAttribute("people", peopleList);

        response.sendRedirect(request.getContextPath() + "/viewPeople.jsp");
    }
}
