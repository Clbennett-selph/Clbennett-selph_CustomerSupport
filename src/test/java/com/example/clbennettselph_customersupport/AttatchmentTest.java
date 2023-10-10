package com.example.clbennettselph_customersupport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttatchmentTest {
    Attachment test = new Attachment();
    @Test
    void getName() {
        test.setName("Jen");
        assertEquals("Jen", test.getName());
    }
}