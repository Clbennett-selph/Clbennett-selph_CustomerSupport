<html>
<head>
    <title>Current Tickets</title>
</head>
<body>
    <a href="<c:url value='/logout'/>">Logout</a>
    <h2>Ticket posts</h2>
    <a href="<c:url value='/ticket/create'/>">Create Ticekt</a><br>
    <c:choose>
        <c:when test="${ticketDatabase.size() == 0}">
            <p>There are no blog posts yet... </p>
        </c:when>
        <C:otherwise>
            <c:forEach var="ticket" items="${ticketDatabase}">
                Ticket #: <c:out value="${ticket.key}"/>
                <a href="<c:url value='/ticket/view/${blog.key}'/>">
                    <c:out value="${ticket.value.customerName}"/></a><br>
            </c:forEach>

        </C:otherwise>
    </c:choose>
</body>
</html>
