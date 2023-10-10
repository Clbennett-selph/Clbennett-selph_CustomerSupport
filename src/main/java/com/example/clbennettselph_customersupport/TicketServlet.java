package com.example.clbennettselph_customersupport;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet (name = "ticket", value = "/ticket")
public class TicketServlet extends HttpServlet{
    private volatile int Ticket_Id = 1;
    private Map<Integer, Ticket> ticketDB = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action");
        if (action == null) {
            action = "listTickets";
        }
        switch(action){
            //listTickets - list all the tickets
            case "listTickets" -> listTickets(request, response);
            //viewTicket - view one ticket based on the id sent
            case "viewTicket" -> viewTicket(request, response);
            //downloadAttachment - downloads the attachment (The book provides good coding example)
            case "downloadTicketForm" -> downloadTicket(request, response);
            //showTicketForm - HTML based form that has user enter in information and calls this action
            case "showTicketForm" -> showTicket(request, response);
            //processAttachment - processes the attachment using Part and InputStream
            case "processAttatchment" -> processAttatchment(request, response);
            //getTicket - gets a ticket based off the id and returns it (helper method for view and download methods)
            case "getTicket"-> getTicket(request, response);
            default -> listTickets(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }
        switch (action) {

            //createTicket - called from the ticket form to create a ticket and add to Hash map
            case "createTicket" -> createTicket(request, response);
            default -> response.sendRedirect("ticket");
        }
    }
    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter print = response.getWriter();
        print.println("<html><body><h2>Ticket Posts</h2>");
        print.println("<a href=\"ticket?action=showTicketForm\">Create Ticket</a><br><br>");

        if (ticketDB.size() == 0){
            print.println("There are currently no tickets.....");
        }
        else {
            for (int id: ticketDB.keySet()) {
                Ticket ticket = ticketDB.get(id);
                print.println("Ticket #" + id);
                print.println("<a href=\"ticket?action=view&ticketId=" + id + "\">");
                print.println(ticket.getCustomerName() + "</a><br>");
            }
        }
        print.println("</body></html>");
    }

    private void viewTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void downloadTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void showTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter print = response.getWriter();


        print.println("<html><body><h2>Create a Ticket</h2>");
        print.println("<form method=\"POST\" action=\"ticket\" enctype=\"multipart/form-data\">");
        print.println("<input type=\"hidden\" name=\"action\" value=\"create\">");
        print.println("Customer Name: ");
        print.println("<input type=\"text\" name=\"customerName\"><br><br>");
        print.println("Subject: ");
        print.println("<input type=\"text\" name=\"subject\"><br><br>");
        print.println("Description: <br>");
        print.println("<textarea name=\"ticketBody\" rows=\"10\" cols=\"100\"></textarea><br><br>");
        print.println("<input type=\"submit\" value=\"Submit\">");
        print.println("</form></body></html>");
    }

    private void processAttatchment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void getTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter print = response.getWriter();
        print.println("<html><body><h2>Ticket Posts</h2>");
        print.println("<a href=\"ticket?action=createTicket\"");
    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ticket tick = new Ticket();
        tick.setCustomerName(request.getParameter("customerName"));
        tick.setSubject(request.getParameter("subject"));
        tick.setTicketBody(request.getParameter("ticketBody"));

        int id;
        synchronized(this) {
            id = this.Ticket_Id++;
            ticketDB.put(id, tick);
        }
        response.sendRedirect("ticket?action=view&ticketId=" + id);
    }
}
