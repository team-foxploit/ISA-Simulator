package com.foxploit;

import java.util.HashMap;

public class DataMemory {

    //data memory using HashMap
    static HashMap<Integer,Integer> dataMemory;

    //write operation
    public static void setDataMemory(int address,int data){
        dataMemory.put(address,data);
    }

    //read operation
    public static void getDataMemory(int address){
        dataMemory.get(address);
    }
    
}
