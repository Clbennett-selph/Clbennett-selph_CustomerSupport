package com.example.clbennettselph_customersupport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttatchmentTest {
    Attatchment test = new Attatchment();
    @Test
    void getName() {
        test.setName("Jen");
        assertEquals("Jen", test.getName());
    }
    //@Test
    //I need to do more studying on what bytes are, and how to use them.
    //void getContents() {
    //    test.setContents();
    //}
}