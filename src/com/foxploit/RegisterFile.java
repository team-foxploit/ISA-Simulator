package com.foxploit;

public class RegisterFile {

    //register file -> 32 registers
    static int [] regFile = new int[32];

    //insert data
    public static void setData(int regNo, int data){
        regFile[regNo] = data;
    }

    //get data
    public static int setData(int regNo){
        return regFile[regNo];
    }
}

