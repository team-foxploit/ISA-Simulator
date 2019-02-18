package com.foxploit;
import java.util.*;

public class InstructionMemory extends Memory{

    // Program counter
    public int p_c = 0;

    //Create a instruction memory
    public Map<Integer, String> instructionMemory = new HashMap<>();




    // Get data from instruction memory
    @Override
    public String getData(int address) {
        return instructionMemory.get(address);
    }

    // Get the instruction memory size
    public int getSize(){
        return instructionMemory.size();
    }

    // Set data to instruction memory
    @Override
    public void setData(int address, String data) {
        instructionMemory.put(address, data);
        // System.out.println("set data");
    }

    @Override
    protected void setData(int addr, int data) {
    }

    // Instruction Decode
    public static int[] instructionDecode(InstructionMemory instMem, int instrAddress){
        // TODO: divide opcode, func and select
        int[] decoded = new int[3];
        try{
            decoded[0] = (int) Integer.parseInt(instMem.getData(instrAddress).substring(0, 6));
            if(decoded[0] != 0){
                // System.out.println("non R type");
            }else{
                System.out.println("R type");
                // TODO : set select and funct
                // TODO : decoded[1], decoded[2]
            }
        }catch (NumberFormatException e){
            System.out.println("Instruction decode failed");
            System.exit(-1);
            e.printStackTrace();
        }
        return decoded;
        // Return decoded codes, (opcode, select, funct)
        // decoded[0] = opcode
        // decoded[1] = select
        // decoded[2] = funct
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
