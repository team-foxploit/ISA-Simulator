package com.foxploit;

public class ALU {
        public static int calculateResult(int data1, int data2, int select){
            int result = 0;
              switch (select){
                    case 0:
                        result = data1 + data2;         // Add instruction
                        break;
                    case 1:
                        result = data1 - data2;         // Sub instruction
                        break;
                    case 2:
                        result = data1 * data2;         // Mul instruction
                        break;
                    case 3:
                        result = data1 / data2;         // Div instruction
                        break;
                    case 4:
                        result = data1 & data2;         // And instruction
                        break;
                    case 5:
                        result = data1 | data2;         // Or instruction
                        break;
                    case 6:
                        result = ~(data1 | data2);      // Nor instruction
                        break;
                    case 7:
                        result = data1 ^ data2;         // Xor instruction
                        break;
                    case 8:
                        result = data1 >> data2;        // Shift right instruction
                        break;
                    case 9:
                        result = data1 << data2;        // Shift left instruction
                        break;
                    case 10:
                        if(data1 < data2){            // Less than instruction
                            result = 1;
                        }
                        else{
                            result = 0;
                        }
                        break;
                  case 12:
                      if(data1==data2){             // Branch equals instruction
                          result = 1;
                      }
                      else{
                          result = 0;
                      }
                      break;
                  case 13:
                      if(data1 > data2){              // Branch greater than instruction
                          result = 1;
                      }
                      else{
                          result = 0;
                      }
                      break;

                }
            return result;
        }


}
