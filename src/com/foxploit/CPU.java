package com.foxploit;

public class CPU {
    public void process(RegisterFile regFile){

        // TODO : Execute each instruction
        int[] codeArray;
        int opcode, rs, rt, rd, shamt, func, imm;
        for (int pc = 0; pc < InstructionMemory.getSize() ; pc++) {
            opcode = (int) Integer.parseInt(InstructionMemory.getData(pc).substring(0, 6));
            switch (opcode){
                case 0:
                    int select = 0;
                    try{
                        rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                        rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                        rd = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(16, 21)));
                        shamt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(21, 26)));
                        func = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(26)));
                        switch (func) {
                            case 32:
                                select = 0;
                                System.out.println(">> add r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 34:
                                select = 1;
                                System.out.println(">> sub r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 24:
                                select = 2;
                                System.out.println(">> mul r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 26:
                                select = 3;
                                System.out.println(">> div r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 36:
                                select = 4;
                                System.out.println(">> and r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 37:
                                select = 5;
                                System.out.println(">> or r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 39:
                                select = 6;
                                System.out.println(">> nor r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 38:
                                select = 7;
                                System.out.println(">> xor r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 2:
                                select = 8;
                                System.out.println(">> slr r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 0:
                                select = 9;
                                System.out.println(">> sll r"+rd+", r"+rt+", r"+rs);
                                break;
                            case 42:
                                select = 10;
                                System.out.println(">> slt r"+rd+", r"+rt+", r"+rs);
                                break;
                            default:
                                System.out.println("Invalid R-Type Instruction");
                        }
                        regFile.setData(rd, ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), select));
                        System.out.println("result : "+ regFile.getData(rd));
                    }catch (NumberFormatException e){
                        System.out.println("Instruction execution failed");
                        System.exit(-1);
                        e.printStackTrace();
                    }
                    break;
                case 1000:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, ALU.calculateResult(regFile.getData(rs), imm, 0));
                    System.out.println("r"+rt+" "+regFile.getData(rt));
                    break;
                case 1100:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, ALU.calculateResult(regFile.getData(rs), imm, 1));
                    break;
                case 100:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
                    if (ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), 12) == 1) {
                        InstructionMemory.p_c = imm - 1;
                    }
                    break;
                case 111:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
                    if (ALU.calculateResult(regFile.getData(rs), regFile.getData(rt), 13) == 1) {
                        InstructionMemory.p_c = imm - 1;
                    }
                    break;
                case 100011:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
                    regFile.setData(rt, DataMemory.getDataMemory(ALU.calculateResult(regFile.getData(rs), imm, 0)));
                    break;
                case 101011:
                    rs = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6, 11)));
                    rt = InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(11, 16)));
                    imm = InstructionMemory.binaryToDecimal((int) Long.parseLong(InstructionMemory.getData(pc).substring(17)));
                    System.out.println(">> rs: "+rs+" rt: "+rt+" imm: "+imm);
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
                    InstructionMemory.p_c = regFile.getData(InstructionMemory.binaryToDecimal((int) Integer.parseInt(InstructionMemory.getData(pc).substring(6)))) - 1;
                    break;
                default:
                    System.out.println("Invalid instruction");
            }
        }

    }
}
