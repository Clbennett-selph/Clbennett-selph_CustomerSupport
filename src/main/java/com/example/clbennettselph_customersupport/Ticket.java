package com.example.clbennettselph_customersupport;

import java.util.LinkedHashMap;
import java.util.Map;

//The fields include:
  //      customer name(String) Done
  //      subject(String)      Done
  //      body of the ticket(String) Done
  //      attachments (Hash map) Done?

  //      This POJO should have a constructor that takes on all fields and a default that   DONE
  //      doesn't take on any. (So two constructors)  DONE
  //      You should have the getters and setters     DONE

public class Ticket {
    private String customerName;
    private String subject;
    private String ticketBody;
    private Map<String, String> customerDB = new LinkedHashMap<String, String>();
    //Not sure if this part with the LinkedMap or any part involving it is coded properly, I think it is???

    public Ticket() {
        super();
    }
    public Ticket(String customerName, String subject, String ticketBody, Map customerDB) {
        this.customerName = customerName;
        this.subject = subject;
        this.ticketBody = ticketBody;
        this.customerDB = customerDB;
    }
      public String getCustomerName(){
          return this.customerName;
      }
      public void setCusomerName(String customerName){
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
      public Map getCustomerDB(){
          return this.customerDB;
      }
      public void setCustomerDB(Map customerDB){
          this.customerDB = customerDB;
      }

      //      Also create the following helper methods    Done?
      //      addAttachment - adds an attachment into the hash map     Done?
      //      getNumberOfAttachments - returns the size of the attachment hash map   Done?
      //      get an individual attachment via an index value sent   Done?
      //      get all attachments   Done?

      public void addAttachment(){
          //Not sure how this would be implemented yet
          // capitalCities.put("England", "London");
        customerDB.put(this.customerName, this.subject);
      }
      public void getNumberOfAttatchments() {
        customerDB.size();
      }
      public void getSpecificAttachment(){
        customerDB.get(this.customerName);
      }
      public void getAllAttatchments(){
          for (String i : customerDB.values()) {
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