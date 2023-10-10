package com.example.clbennettselph_customersupport;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ticket {
    //      customer name(String)
    private String customerName;

    //      subject(String)
    private String subject;

    //      body of the ticket(String)
    private String ticketBody;

    //      attachments (Hash map) Done?
    private Map<String, String> attatchments = new LinkedHashMap<String, String>();
    //Not sure if this part with the LinkedMap or any part involving it is coded properly, I think it is???


    //      This POJO should have a constructor that takes on all fields and a default that
    //      doesn't take on any. (So two constructors)
    public Ticket() {
        super();
    }
    public Ticket(String customerName, String subject, String ticketBody, Map attatchments) {
        this.customerName = customerName;
        this.subject = subject;
        this.ticketBody = ticketBody;
        this.attatchments = attatchments;
    }

    //      You should have the getters and setters
    public String getCustomerName(){
          return this.customerName;
      }
      public void setCustomerName(String customerName){
          this.customerName = customerName;
      }
      public String getSubject(){
          return this.subject;
      }
      public void setSubject(String subject){
          this.subject = subject;
      }
      public String getTicketBody(){
          return this.ticketBody;
      }
      public void setTicketBody(String ticketBody){
          this.ticketBody = ticketBody;
      }
      public Map getAttatchments(){
          return this.attatchments;
      }
      public void setAttatchments(Map attatchments){
          this.attatchments = attatchments;
      }


    //      addAttachment - adds an attachment into the hash map
    public void addAttachment(){
          attatchments.put(this.customerName, this.subject);
      }

    //      getNumberOfAttachments - returns the size of the attachment hash map
    public int getNumberOfAttatchments() {
        return attatchments.size();
      }

    //      get an individual attachment via an index value sent
    public String getSpecificAttachment(){return attatchments.get(this.customerName);}

    //      get all attachments
    public void getAllAttatchments(){
          for (String i : attatchments.values()) {
              System.out.println(i);
          }
      }
      @Override
      public String toString() {
          return "Ticket{" +
                  "customerName='" + customerName + '\'' +
                  ", subject='" + subject + '\'' +
                  ", ticketBody='" + ticketBody + '\'' +
                  '}';
      }
  }