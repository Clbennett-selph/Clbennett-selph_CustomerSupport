<%@ page import="java.util.Map" %>
<%@ page import="com.example.clbennettselph_customersupport.Ticket" %>
<%
        @SuppressWarnings("unchecked")
        Map<Integer, Ticket> db = (Map<Integer, Ticket>) request.getAttribute("ticketDB");
%>

<html>
<head>
    <title>Current Tickets</title>
</head>
<body>
    <a href="<c:url value='/login'>
        <c:param name='logout'/>
    </c:url>">Logout</a>

    <h2>Ticket posts</h2>
    <a href="ticket?action=showTicketForm">Create Ticket</a><br><br>
    <%
        if(db.size() == 0) {%>
            <%="There are no tickets yet..."%>
        <%}
        else {
            for (int id : db.keySet()) {
                Ticket tick = db.get(id);%>
                <%="Ticket # " + id + " "%>
                <a href = "ticket?action=viewTicket&ticketId=<%=id%>"><%=tick.getSubject()%></a><br>
            <%}
        }%>
</body>
</html>
