<%@ page import="com.example.clbennettselph_customersupport.Ticket" %>

<%
        String ticketId = (String)request.getAttribute("ticketId");
        Ticket tick = (Ticket)request.getAttribute("ticket");
%>

<html>
<head>
    <title>Ticket #<%=ticketId%></title>
</head>

<body>

    <a href="<c:url value='/login'>
        <c:param name='logout'/>
    </c:url>">Logout</a>
    <h2>Ticket Post #<%=ticketId%></h2>
    <h3>Subject: <%=tick.getSubject()%></h3>
    <p>Customer: <%=tick.getCustomerName()%></p>
    <p><%=tick.getTicketBody()%></p>
    <a href="ticket">Return to Ticket list</a>
    <br>
</body>
</html>
