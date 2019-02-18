
public class ALU {
        int result=0;
        public int calculateResult(int data1,int data2,int select){
              switch (select){
                    case 1:
                        result=data1+data2;         //add
                        break;
                    case 2:
                        result=data1-data2;         //sub
                        break;
                    case 3:
                        result=data1*data2;         //mul
                        break;
                    case 4:
                        result=data1/data2;         //div
                        break;
                    case 5:
                        result=data1&data2;         //and
                        break;
                    case 6:
                        result=data1|data2;         //or
                        break;
                    case 7:
                        result=~(data1|data2);      //nor
                        break;
                    case 8:
                        result=data1^data2;         //xor
                        break;
                    case 9:
                        result=data1>>data2;        //shift right
                        break;
                    case 10:
                        result=data1<<data2;        //shift left
                        break;
                    case 11:
                        if(data1<data2){            //less than
                            result=1;
                        }
                        else{
                            result=0;
                        }
                        break;
                  case 12:
                      System.out.println("Syscall");    //syscall
                      break;
                  case 13:
                      if(data1==data2){             //branch equals
                          result=1;
                      }
                      else{
                          result=0;
                      }
                      break;
                  case 14:
                      if(data1>data2){              //branch greater than
                          result=1;
                      }
                      else{
                          result=0;
                      }
                      break;

                }

            return result;
        }


}




