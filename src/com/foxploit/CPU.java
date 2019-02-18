package com.foxploit;

public class CPU {
    public void process(RegisterFile regFile){

        // TODO : Execute each instruction
        int[] codeArray;
        int rs, rt, rd, shamt, func, imm;
        for (int pc = 0; pc < InstructionMemory.getSize() ; pc++) {
            // System.out.println("Instruction: " + pc + " " + instMem.getData(pc));
            codeArray = InstructionMemory.instructionDecode(pc);
             System.out.println(codeArray[0]);
            switch (codeArray[0]){
                case 0:
                    int select = 0;
                    System.out.println("ALU operations");
                    System.out.println(InstructionMemory.getData(pc));
                    try{
                        rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                        rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                        rd = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(16, 21)));
                        shamt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(21, 26)));
                        func = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(26)));
                        System.out.print("Source reg : " + rs);
                        System.out.print(" Temp reg : " + rt);
                        System.out.print(" Dest reg : " + rd);
                        System.out.print(" Shamt reg : " + shamt);
                        System.out.println(" Func reg : " + func);
                        switch (func) {
                            case 32:
                                select = 0;
                                break;
                            case 34:
                                select = 1;
                                break;
                            case 24:
                                select = 2;
                                break;
                            case 26:
                                select = 3;
                                break;
                            case 36:
                                select = 4;
                                break;
                            case 37:
                                select = 5;
                                break;
                            case 39:
                                select = 6;
                                break;
                            case 38:
                                select = 7;
                                break;
                            case 2:
                                select = 8;
                                break;
                            case 0:
                                select = 9;
                                break;
                            case 42:
                                select = 10;
                                break;
                            case 12:
                                select = 11;
                                break;
                            default:
                                System.out.println("Invalid R-Type Instruction");
                        }
                        System.out.println("Select : "+ select);
                        // TODO : get real data from register file
                        rd = ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), select);
                        System.out.println("result : "+ rd);
                    }catch (NumberFormatException e){
                        System.out.println("Instruction execution failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }
                    break;
                case 100011:
                    // TODO : Load instruction
                    System.out.println("Load instruction");
                    try{
                        rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                        rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                        imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                        System.out.print("Source reg : " + rs);
                        System.out.print(" Temp reg : " + rt);
                        System.out.println(" Imm value : " + imm);
                        // TODO : get real data from register file
                        rt = DataMemory.getDataMemory(rs + imm);
                        System.out.println("result : "+ rt);
                    }catch (NumberFormatException e){
                        System.out.println("Instruction execution failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }catch (NullPointerException e){
                        System.out.println("Data memory load failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }
                    break;
                case 101011:
                    // TODO : Store instruction
                    System.out.println("Store instruction");
                    try{
                        rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                        rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                        imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                        System.out.print("Source reg : " + rs);
                        System.out.print(" Temp reg : " + rt);
                        System.out.println(" Imm value : " + imm);
                        // TODO : get real data from register file
                        DataMemory.setDataMemory(rs+imm, rt);
                        System.out.println("result : "+ rt);
                    }catch (NumberFormatException e){
                        System.out.println("Instruction execution failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }catch (NullPointerException e){
                        System.out.println("Data memory insertion failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }
                    break;
            }
        }

    }
}
