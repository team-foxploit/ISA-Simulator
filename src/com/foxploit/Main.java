package com.foxploit;

public class Main {

    String[] smpl_instr = {
            "add rd, rs, rt"
    };

    public static void main(String[] args) {
        System.out.println("Hello");
        RegisterFile.setData(31, 10);
        System.out.println(RegisterFile.getData(30));
        Memory instMem = new InstructionMemory();
        instMem.setData(101101, 1000);
        System.out.println(instMem.getData(101101));
    }
}
