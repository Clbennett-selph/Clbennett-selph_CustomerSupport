package com.example.clbennettselph_customersupport.site;

import java.io.Serializable;
import java.util.Arrays;

public class Attachment implements Serializable {

    //Two private instance variables - String name and a byte array contents
    private String name;
    private byte[] contents;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte[] getContents() {
        return contents;
    }
    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "name='" + name + '\'' +
                ", contents=" + Arrays.toString(contents) +
                '}';
    }
}
