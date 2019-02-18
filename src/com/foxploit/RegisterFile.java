package com.foxploit;

public class RegisterFile {

    private int[] register = new int[32];

    // Retrieve data from the register file
    public int getData(int address){
        return register[address];
    }

    // Save data to the register file
    public void setData(int address, int data){
        register[address] = data;
    }

    //  for beq instructions
    public void setReturn(int address){
        register[31]=address;
    }
}
