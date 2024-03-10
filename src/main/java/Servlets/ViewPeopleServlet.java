package Servlets;

import Model.Person;
import Repository.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewPeopleServlet", value = "/viewPeople")
public class ViewPeopleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Repository repository = new Repository();

        ArrayList<Person> peopleList = repository.getPeople();
        HttpSession session = request.getSession(true);
        session.setAttribute("people", peopleList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewPeople.jsp");
        dispatcher.forward(request, response);
    }

}