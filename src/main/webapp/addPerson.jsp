<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add person</title>
    <style>
        body {
            margin: 0;
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
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
<form action="addPerson" method="post">
    <label>Please add person</label>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" required>
    <br>
    <label for="age">Age:</label>
    <input type="text" id="age" name="age" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
