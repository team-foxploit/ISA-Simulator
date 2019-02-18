package com.foxploit;
import java.util.*;

public class InstructionMemory extends Memory{

    // Program counter
    public static int p_c = 0;

    //Create a instruction memory
    private Map<Integer, Integer> instructionMemory = new HashMap<>();

    // Get data from instruction memory
    @Override
    public int getData(int address) {
        return instructionMemory.get(address);
    }

    // Set data to instruction memory
    @Override
    protected void setData(int address, int data) {
        instructionMemory.put(address, data);
    }
}
