<html>
<head>
    <title>Current Tickets</title>
</head>
<body>
    <a href="<c:url value='/logout'/>">Logout</a>
    <h2>Ticket posts</h2>
    <a href="<c:url value='/ticket/create'/>">Create Ticket</a><br>
    <c:choose>
        <c:when test="${ticketDatabase.size() == 0}">
            <p>There are no ticket posts yet... </p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ticket" items="${ticketDatabase}">
                Ticket #: <c:out value="${ticket.key}"/>
                <a href="<c:url value='/ticket/view/${ticket.key}'/>">
                    <c:out value="${ticket.value.customerName}"/></a><br>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
