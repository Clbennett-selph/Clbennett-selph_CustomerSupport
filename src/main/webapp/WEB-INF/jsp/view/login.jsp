<html>
<head>
    <title>Ticket Login</title>
</head>
<body>
    <h2>Login</h2>
    You must log in to access current tickets.<br><br>
    <!-- These two actions didn't want to play nice, not sure why.
    <form method="POST" action="<c:url value='/login'/>"
    <form method="POST" action="/login">
    Managed to get it to work using below code, but would like to know what I messed up on the other 2, thanks!
    -->

    <form method="POST" action="${pageContext.request.contextPath}/login">
        <c:if test="${loginFailed == true}">
            <b><c:out value="The username or password you have entered are incorrect, Please try again."></c:out></b>
        </c:if>
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Log In">
    </form>
</body>
</html>
