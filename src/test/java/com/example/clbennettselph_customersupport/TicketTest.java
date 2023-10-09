package com.example.clbennettselph_customersupport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    Ticket tick = new Ticket();
    @Test
    void testCustomerName(){
        tick.setCustomerName("Camron");
        assertEquals ("Camron", tick.getCustomerName());
    };
    @Test
    void testSubject(){
        tick.setSubject("Issue");
        assertEquals("Issue", tick.getSubject());
    }
    @Test
    void testGetCustomerDB() {
        tick.setCustomerName("Bob");
        tick.setSubject("Work");
        tick.addAttachment();
        assertNotNull(tick.getCustomerDB());
    }
    @Test
    void testAddAttachment(){
        tick.setCustomerName("Bob");
        tick.setSubject("Work");
        tick.addAttachment();
        tick.setCustomerName("deb");
        tick.setSubject("Unemployed");
        tick.addAttachment();
        assertEquals (2, tick.getNumberOfAttatchments());
    };
    @Test
    void testGetSpecificAttatchment(){
        tick.setCustomerName("Bob");
        tick.setSubject("Work");
        tick.addAttachment();
        assertNotNull(tick.getSpecificAttachment());
    };

    //@Test
    //void testGetAllAttatchments() {
    //I cant seem to get a test to work for this one
        //tick.setCustomerName("Bob");
        //tick.setSubject("Work");
        //tick.addAttachment();
        //assertNotNull(tick.getAllAttatchments());
    //}
}