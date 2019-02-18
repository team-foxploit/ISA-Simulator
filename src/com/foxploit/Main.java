package com.foxploit;

public class Main {

    static String[] smpl_instr = {
            "00100000000000000000000000001100",
            "00100000001000000000000000001010",
            "00000000000000010001000100100000",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11110000111010001000010100000110",
            "11111111111111111111111111111111",
            "10101111111111111111111111111111",
            "10001111111111111111111111111111"

    };

    public static void main(String[] args) {

        // Create a Register file instance
        RegisterFile regFile = new RegisterFile();

        // TODO : cretae real load save instruction
        // Dummy register load
        regFile.setData(0, 10);
        regFile.setData(1, 20);
        System.out.println(regFile.getData(0));
        System.out.println(regFile.getData(1));

        // test binaryToDecimal method
        // System.out.println(binaryToDecimal(Integer.parseInt(new Main().smpl_instr[1].substring(0, 5))));

        int i = 0;
        for (String tempInst: smpl_instr) {
            InstructionMemory.setData(i++, tempInst);
        }

        CPU cpu = new CPU();
        cpu.process(regFile);

    }

}
