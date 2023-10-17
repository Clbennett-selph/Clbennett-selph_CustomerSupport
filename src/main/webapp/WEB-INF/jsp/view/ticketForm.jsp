<html>
<head>
    <title>Create a new Ticket</title>
</head>
<body>
    <h2>Create a Ticket</h2>
    <form method="POST" action="ticket" enctype="multipart/form-data">
    <input type="hidden" name="action" value="createTicket">
    Customer Name:
    <input type="text" name="customerName"><br><br>
    Subject:
    <input type="text" name="subject"><br><br>
    Description: <br>
    <textarea name="ticketBody" rows="10" cols="100"></textarea><br><br>
    <input type="submit" value="Submit">
    </form>

</body>
</html>
