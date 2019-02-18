package com.foxploit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

   /* static String[] smpl_instr = {
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
*/
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

        // Create a InstructionMemory instance
        InstructionMemory instMem = new InstructionMemory();


        //read the input file

            BufferedReader br = null;
            int count=0;
            try {
                br = new BufferedReader(new FileReader("C:\\Users\\Sajini\\IdeaProjects\\processor\\src\\com\\foxploit\\input.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String strLine = "";
            while (strLine != null)
            {
                try {
                    strLine =br.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (strLine==null)
                    break;
                //add to the hashmap
                instMem.setData(count,strLine);


                count++;
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



     /*  int i = 0;
        for (String tempInst : smpl_instr) {
            instMem.setData(i++, tempInst);
        }
*/
        //check instruction memmory has got the data
        System.out.println(instMem.instructionMemory);



        CPU cpu = new CPU();
        cpu.process(instMem, regFile);

    }
}



