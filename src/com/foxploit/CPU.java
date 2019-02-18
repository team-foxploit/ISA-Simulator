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
                case 1000:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, ALU.calculateResult(regFile.getData(rs), imm, 0));
                    break;
                case 1100:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, ALU.calculateResult(regFile.getData(rs), imm, 1));
                    break;
                case 100:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    if (ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), 12) == 1) {
                        InstructionMemory.p_c = imm - 1;
                    }
                    break;
                case 111:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    if (ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), 13) == 1) {
                        InstructionMemory.p_c = imm - 1;
                    }
                    break;
                case 100011:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, DataMemory.getDataMemory(ALU.calculateResult(regFile.getData(rs), imm, 0)));
                    break;
                case 101011:
                    // TODO : check
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println("rs: "+rs+" rt: "+rt+" imm: "+imm);
                    DataMemory.setDataMemory(ALU.calculateResult(regFile.getData(rs), imm, 0), regFile.getData(rt));
                    break;
                case 10:
                    InstructionMemory.p_c = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6))) - 1;
                    break;
                case 11:
                    RegisterFile.setReturn(InstructionMemory.p_c);
                    InstructionMemory.p_c = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6))) - 1;
                    break;
                case 10000:
                    int addr = regFile.getData(InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6))));
                    InstructionMemory.p_c = addr - 1;
                    break;
                default:
                    System.out.println("Invalid instruction");
            }
        }

    }
}
