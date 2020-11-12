<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
</head>
<body>

<div class="container justify-content-center align-content-center">
    <h3>${welcomeMsg}</h3>
    <form method="post" target="/home">
        <div class="form-group">
            <label for="username">Enter your name:</label>
            <input type="text" name="username" id="username">
            <input type="submit">
        </div>
    </form>
</body>
</html>