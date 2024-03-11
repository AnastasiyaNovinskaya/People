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
<a href="viewPeople">View people</a>
<a href="addPerson.jsp">Add person</a>
<a href="deletePerson.jsp">Delete person</a>
<a href="choosePerson.jsp">Change person</a>
<br>
<br>
<br>
</body>
</html>