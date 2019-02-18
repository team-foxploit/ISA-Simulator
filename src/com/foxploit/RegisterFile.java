package com.foxploit;

public class RegisterFile {

    private static int[] register = new int[32];

    // Retrieve data from the register file
    public int getData(int address){
        return register[address];
    }

    // Save data to the register file
    public static void setData(int address, int data){
        register[address] = data;
    }

    //  for beq instructions
    public static void setReturn(int address){
        register[31]=address;
    }
}
