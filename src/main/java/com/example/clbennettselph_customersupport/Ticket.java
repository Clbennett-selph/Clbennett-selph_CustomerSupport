package com.example.clbennettselph_customersupport;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket {
    private String customerName; //      customer name(String)
    private String subject; //      subject(String)
    private String ticketBody; //      body of the ticket(String)
    private Map<String, String> attachments = new LinkedHashMap<>();

    //      attachments (Hash map) Done?
    //      Not sure if this part with the LinkedMap or any part involving it is coded properly, I think it is???

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
      public Map getAttachments(){
          return attachments;
      }
      public void setAttachments(Map attachments){
          this.attachments = attachments;
      }


    //      addAttachment - adds an attachment into the hash map
    public void addAttachment(){
          attachments.put(this.customerName, this.subject);
    }

    //      getNumberOfAttachments - returns the size of the attachment hash map
    public int getNumberOfAttachments() {
        return attachments.size();
    }

    //      get an individual attachment via an index value sent
    public String getSpecificAttachment(){return
            attachments.get(this.customerName);}

    //      get all attachments
    public void getAllAttachments(){
         for (String i : attachments.values()) {
              System.out.println(i);
          }
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