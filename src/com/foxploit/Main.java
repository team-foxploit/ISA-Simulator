package com.foxploit;

public class Main {

    String[] smpl_instr = {
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110"
    };

    public static void main(String[] args) {

        // There should be only one register file
        System.out.println("Hello");
        RegisterFile regFile = new RegisterFile();
        regFile.setData(31, 10);
        System.out.println(regFile.getData(30));

        // Create a InstructionMemory instance
        Memory instMem = new InstructionMemory();
        instMem.setData(101101, 1000);
        System.out.println(instMem.getData(101101));
    }
}
