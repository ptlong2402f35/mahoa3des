/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author PC
 */
public class TextElement {
    private String text;
    private int out;
    public TextElement() {
    }
    
    public void setText(String input) {
        init(input);
    }
    
    public void init(String input){
        String temp = input;
        int du = input.length() % 8;
        this.out = du;
        if(du != 0) {
            //update boi so 8 byte dung byte padding
            for(int i= 0; i< 8 - du;i++){
                temp += new Character((char) (8-du)).toString();
            }
        }
        this.text = temp;
    }
    
    public String getText() {
        return this.text;
    }
    
    public int getOut() {
        return this.out;
    }
    
    public String[] getElementTextList() {
        int retLen = this.text.length() / 8;
        int out = this.text.length() % 8;
        String[] ret = new String[out >0 ? retLen + 1 : retLen];
        int retIndex = 0;
        for(int i =0; i< this.text.length(); i+=8) {
            String item = "";
            for(int j=0;j < 8;j++) {
                int index = i+j;
                int asciiVal = this.text.charAt(index);
                String binVal = Integer.toBinaryString(asciiVal);
                while (binVal.length() < 8) {
                    binVal = "0" + binVal;
                }
                item+= binVal;
            }
            ret[retIndex] = item;
            retIndex++;
        }
        return ret;
    }
    
    public String convertElementToBinary(String input){
        String item = "";
        for(int j=0;j < input.length();j++) {
            int asciiVal = input.charAt(j);
            String binVal = Integer.toBinaryString(asciiVal);
            while (binVal.length() < 8) {
                    binVal = "0" + binVal;
            }
            item+= binVal;
            }
        return item;
    }
    
    public String convertBinToAscii(String input, boolean isDecrypt) {
        String ret = "";
        for(int i =0; i< input.length(); i+=8) {
            int number = 0;
            for(int j =0 ;j < 8; j++) {
               int index = i+j;
               char c = input.charAt(index);
               int iValue = Character.getNumericValue(c);
               double asciiNumber = iValue * Math.pow(2,7-j);
               number += (int)asciiNumber;
            }
            if(isDecrypt && number > 8) {
                ret+= (char) number;
            }
            if(!isDecrypt) {
                ret+= (char) number;
            }
            
            System.out.println(number);
        }
        
        return ret;
    }
}
