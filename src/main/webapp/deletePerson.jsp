<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete person</title>
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
            font-weight: bold; /* Устанавливаем жирный шрифт */
        }
    </style>
</head>
<body>
<form action="deletePerson" method="post">
    <label for="id">Select person ID</label>
    <input type="text" id="id" name="id" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
