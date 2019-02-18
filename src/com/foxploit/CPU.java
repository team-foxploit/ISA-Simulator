package com.foxploit;

public class CPU {
    public void process(InstructionMemory instMem, RegisterFile regFile){

        // TODO : Execute each instruction
        for (int pc = 0; pc < instMem.getSize() ; pc++) {
            System.out.println(instMem.getData(pc));
        }

    }
}
