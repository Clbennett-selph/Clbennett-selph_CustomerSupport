package com.example.clbennettselph_customersupport;

import java.util.Arrays;

public class Attatchment {
    //Two private instance variables - String name and a byte array contents
    private String name;
    private byte[] contents;
    public Attatchment() {
        super();
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte[] getContents() {
        return this.contents;
    }
    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    //What does this code do?
    //public String toString() {
    //   String var10000 = this.name;
    //   return "Image{name='" + var10000 + "', contents=" + Arrays.toString(this.contents) + "}";
    //}

}
