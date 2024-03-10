<%@ page import="Model.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin-top: 50px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        a {
            display: inline-block;
            margin: 0 10px;
            padding: 10px 0;
            width: 170px;
            text-decoration: none;
            color: #fff;
            background-color: #000000;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #3868b1;
        }
    </style>
</head>
<body>
<h2>Hello People!</h2>
<a href="addPerson.jsp">Add person</a>
<a href="deletePerson.jsp">Delete person</a>
<a href="choosePerson.jsp">Change person</a>
<br>
<br>
<br>
<form action="viewPeople" method="post">
    <table style="width: 50%; margin: 0 auto; border-collapse: collapse; margin-bottom: 20px; border: 2px solid black;">
        <tr>
            <th style="width: 5%;">ID</th>
            <th style="width: 40%;">Name</th>
            <th style="width: 40%;">Surname</th>
            <th style="width: 15%;">Age</th>
        </tr>
        <%
            ArrayList<Person> people = (ArrayList<Person>) session.getAttribute("people");
            if (people != null && !people.isEmpty()) {
                for (Person person : people) {
        %>
        <tr>
            <td><%= person.getId() %></td>
            <td><%= person.getName() %></td>
            <td><%= person.getSurname() %></td>
            <td><%= person.getAge() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            No people available.
            <br>
        </tr>
        <%
            }
        %>
    </table>
</form>
</body>
</html>