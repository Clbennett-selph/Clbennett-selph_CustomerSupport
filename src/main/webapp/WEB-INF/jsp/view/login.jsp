<html>
<head>
    <title>Ticket Login</title>
</head>
<body>
<h2>Login</h2>
You must log in to access current tickets.<br><br>
    <form method="POST" action="<c:url value='/login'/>"
    <c:if test="${loginFailed == true}">
        <b><c:out value="The username or password you have entered are incorrect, Please try again."></c:out></b>
    </c:if><br>

    Username: <input type="text" name="username"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Log In">
</form>
</body>
</html>
