<%@ page import="Model.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Person</title>
    <style>
        body {
            margin: 0;
            overflow: hidden;
            display: flex;
            align-items: center; /* Центрирование по вертикали */
            justify-content: center; /* Центрирование по горизонтали */
            height: 100vh; /* 100% высоты окна браузера */
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
        }
        label {
            display: block;
            text-align: center;
            margin-bottom: 10px;
            font-family: 'Arial', sans-serif;
            font-size: 16px;
        }
        input {
            display: block;
            margin: 0 auto;
            width: 200px;
            font-family: 'Arial', sans-serif;
            font-size: 16px;
        }
        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<% Person person = (Person) request.getAttribute("person"); %>
<% if (person != null) { %>
<form action="updatePerson" method="post">
    <label>Update person details</label>
    <input type="hidden" name="id" value="<%= person.getId() %>">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= person.getName() %>"><br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" value="<%= person.getSurname() %>"><br>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" value="<%= person.getAge() %>"><br>
    <input type="submit" value="Update">
</form>
<% } else { %>
<p>No person found with the selected ID.</p>
<% } %>
</body>
</html>
