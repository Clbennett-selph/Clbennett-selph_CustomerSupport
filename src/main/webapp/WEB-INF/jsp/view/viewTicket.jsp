<html>
<head>
    <title>Ticket #<c:out value="${ticketId}"/></title>
</head>

<body>
<a href="<c:url value='/logout'/>">Logout</a>
    <h2>Ticket Post #<c:out value="${ticketId}"/>: <c:out value="${blog.title}"/> </h2>
    <h3>Customer: <c:out value="${ticket.customerName}"/></h3>
    <h3>Subject: <c:out value="${ticket.subject}"/></h3>
    <p>Description:</p><br>
    <p><c:out value="${ticket.ticketBody}"/></p><br>
    <c:if test="${ticket.hasAttachment()}">
        <a href="<c:url value='/ticket/${ticketId}/attachment/${ticket.attachments.name}' />">
            <c:out value="${ticket.attachments.name}"/></a>
    </c:if>
    <a href="<c:url value='/ticket/list'/>">Return to Ticket list</a>
    <br>
</body>
</html>
