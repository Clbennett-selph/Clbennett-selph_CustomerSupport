package com.example.clbennettselph_customersupport.site;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket implements Serializable {
    private String customerName; //      customer name(String)
    private String subject; //      subject(String)
    private String ticketBody; //      body of the ticket(String)
    private Map<String, Attachment> attachments = new LinkedHashMap<>();
    public Ticket() {
        super();
    } //  (two constructors)



    public Ticket(String customerName, String subject, String ticketBody, Map attachments) {
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

    //For your get methods you should have a getAttachment(String name) that gets the specific attachment via the name in the map.
    // Your getAllAttachments should return a Collection<Attachment> that returns the attachments.values().
    // Then the jsp will have a format it can loop through and print out.

    public Attachment getAttachments(){
          return (Attachment) attachments;
      }
      public void setAttachments(Attachment attachments){
          this.attachments = (Map<String, Attachment>) attachments;
      }

    //      addAttachment - adds an attachment into the hash map
    public void addAttachment(){
        //Attachment attachment = new Attachment();
        //  attachments.put();
    }

    //      getNumberOfAttachments - returns the size of the attachment hash map
    public int getNumberOfAttachments() {
        return attachments.size();
    }

    //      get an individual attachment via an index value sent
    //public String getSpecificAttachment(){
        //Dont believe its getting the right value
        //return attachments.get(customerName);
    //}

    //      get all attachments
    //public void getAllAttachments(){
         //for (String i : attachments.values()) {
              //System.out.println(i);
          //}
      //}

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