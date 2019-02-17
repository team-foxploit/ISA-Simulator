package com.foxploit;

public class RegisterFile {
    static int[] register = new int[32];

    // Retrieve data from the register file
    public static int getData(int address){
        return register[address];
    }

    // Save data to the register file
    public static void setData(int address, int data){
        register[address] = data;
    }

    // TODO: for beq instructions
}
