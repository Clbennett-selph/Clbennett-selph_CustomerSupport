package com.example.clbennettselph_customersupport.site;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String customerName; //      customer name(String)
    private String subject; //      subject(String)
    private String ticketBody; //      body of the ticket(String)
    private Attachment attachments = new Attachment();
    public Ticket() {
        super();
    } //  (two constructors)
    public Ticket(String customerName, String subject, String ticketBody, Attachment attachments) {
        this.customerName = customerName;
        this.subject = subject;
        this.ticketBody = ticketBody;
        this.attachments = attachments;
    }

    //      You should have the getters and setters
    public String getCustomerName(){
          return customerName;
      }
      public void setCustomerName(String customerName){
          this.customerName = customerName;
      }


      public String getSubject(){
          return subject;
      }
      public void setSubject(String subject){
          this.subject = subject;
      }


      public String getTicketBody(){
          return ticketBody;
      }
      public void setTicketBody(String ticketBody){
          this.ticketBody = ticketBody;
      }

      public Attachment getAttachments(){
          return attachments;
      }

      public void setAttachments(Attachment attachments) {this.attachments = attachments;}

    public boolean hasAttachment() {
        return attachments != null && attachments.getName() != null && attachments.getContents() != null;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customerName='" + customerName + '\'' +
                ", subject='" + subject + '\'' +
                ", ticketBody='" + ticketBody + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}