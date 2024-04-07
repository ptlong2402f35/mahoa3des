/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
/**
 *
 * @author ptlong2402
 */
public class BitDataProccesser {
    public String convertHexToBin(String input) {
        String ret = "";
        for (int i = 0; i < input.length(); i ++) {
            char item = input.charAt(i);
            String curPath;
            switch(item) {
                case '0':
                    curPath = "0000";
                    break;
                case '1':
                    curPath = "0001";
                    break;
                case '2':
                    curPath = "0010";
                    break;
                case '3':
                    curPath = "0011";
                    break;
                case '4':
                    curPath = "0100";
                    break;
                case '5':
                    curPath = "0101";
                    break;
                case '6':
                    curPath = "0110";
                    break;
                case '7':
                    curPath = "0111";
                    break;
                case '8':
                    curPath = "1000";
                    break;
                case '9':
                    curPath = "1001";
                    break;
                case 'A':
                case 'a':
                    curPath = "1010";
                    break;
                case 'B':
                case 'b':
                    curPath = "1011";
                    break;
                case 'C':
                case 'c':
                    curPath = "1100";
                    break;
                case 'D':
                case 'd':
                    curPath = "1101";
                    break;
                case 'E':
                case 'e':
                    curPath = "1110";
                    break;
                case 'F':
                case 'f':
                    curPath = "1111";
                    break;
                default:
                    curPath = ""; 
                    break;
            }
            ret += curPath;
        }
        return ret;
    }
    
    public String convertBinToHex(String input) {
        String ret = "";
        //chen 0 vao dau day input
        while (input.length() % 4 != 0) {
            input = "0" + input;
        }
        for(int i = 0 ; i < input.length(); i +=4) {
            String item = input.substring(i, i + 4);
            int binValue = 0;
            for( int j =0; j < item.length(); j++) {
                binValue += Math.pow(2, item.length() - 1 - j) * Character.getNumericValue(item.charAt(j));
            }
            switch(binValue) {
                case 0:
                    ret += "0";
                    break;
                case 1:
                    ret += "1";
                    break;
                case 2:
                    ret += "2";
                    break;
                case 3:
                    ret += "3";
                    break;
                case 4:
                    ret += "4";
                    break;
                case 5:
                    ret += "5";
                    break;
                case 6:
                    ret += "6";
                    break;
                case 7:
                    ret += "7";
                    break;
                case 8:
                    ret += "8";
                    break;
                case 9:
                    ret += "9";
                    break;
                case 10:
                    ret += "A";
                    break;
                case 11:
                    ret += "B";
                    break;
                case 12:
                    ret += "C";
                    break;
                case 13:
                    ret += "D";
                    break;
                case 14:
                    ret += "E";
                    break;
                case 15:
                    ret += "F";
                    break;
                default:
                    break;
            }
        }
        return ret;
    }
    
    public String leftShift(String input, int n) {
        String output = input;
        for(int step = 0; step < n; step ++) {
            int length = output.length();
            char firstChar = output.charAt(0);
            String rotatedString = output.substring(1);
            output = rotatedString + firstChar;
        }

        return output;
    }
    
    public String XORCalc(String input, String compareVal) {
        String ret = "";
        for(int i =0; i< input.length(); i++) {
            if(input.charAt(i) == compareVal.charAt(i)) {
                ret += "0";
            }
            else {
                ret += "1";
            }
        }
        
        return ret;
    }
    
    public String permulation(String input, int[] resources) {
        System.out.println("output permulation");
        int len = resources.length;
        String[] ret = new String[len];
        for(int i =0 ; i < resources.length ;i++ ) {
            int index = resources[i];
            String value = String.valueOf(input.charAt(index - 1));
            ret[i] = value;
        }
        System.out.println(String.join("", ret));
        return String.join("", ret);
    }
    
    public String SBoxPermulation(String input, int[][] resources) {
        System.out.println("input Sbox");
        System.out.println(input);
        String ret = "";
        int index = 0;
        for(int i =0; i< input.length();i+=6){
            String sub = input.substring(i,i+6);
            String pre = "" + sub.charAt(0) + sub.charAt(sub.length() - 1);
            String val = input.substring(1 + i, 5 + i);
            int step;
            switch(pre) {
                case "00": {
                    step = 0;
                    break;
                }
                case "01": {
                    step = 1;
                    break;
                }
                case "10": {
                    step = 2;
                    break;
                }
                case "11": {
                    step = 3;
                    break;
                }
                default: {
                    step = 0;
                    break;
                }
            }
            int decVal = Integer.parseInt(val, 2);
            int fSBoxVal = resources[index][step * 16 + decVal];
            String bin = Integer.toBinaryString(fSBoxVal);
            while (bin.length() % 4 != 0) {
                bin = "0" + bin;
            }
            System.out.println(bin);
            ret += bin;
            index +=1;
        }
        return ret;
    }
}
