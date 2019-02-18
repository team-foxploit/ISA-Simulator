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
            "11111111111111111111111111111111"
    };

    static int binaryToDecimal(int n){
        int num = n;
        int dec_value = 0;

        // Initializing base
        // value to 1, i.e 2^0
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

    public static void main(String[] args) {

        // There should be only one register file
        RegisterFile regFile = new RegisterFile();
        regFile.setData(31, 10);
        System.out.println(regFile.getData(31));

        // test binaryToDecimal method
        // System.out.println(binaryToDecimal(Integer.parseInt(new Main().smpl_instr[1].substring(0, 5))));

        // Create a InstructionMemory instance
        Memory instMem = new InstructionMemory();

        // TODO : Store all instructions in the InstructionMemory at first
        int i = 0;
        for (String tempInst: smpl_instr) {
            instMem.setData(++i, tempInst);
        }

        // TODO : Execute each instruction

        // instMem.setData(101101, smpl_instr[0]);
        System.out.println(instMem.getData(1));
    }

}
