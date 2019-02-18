package com.foxploit;
import java.util.*;

public class InstructionMemory extends Memory{

    // Program counter
    public int p_c = 0;

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
        p_c ++;
        // TODO: divide opcode, func and select
    }

    // Convert binary to decimal
    static int binaryToDecimal(int n){
        int num = n;
        int dec_value = 0;
        int base = 1;
        int temp = num;
        while (temp > 0){
            int last_digit = temp % 10;
            temp = temp / 10;
            dec_value += last_digit * base;
            base = base * 2;
        }
        return dec_value;
    }
}
