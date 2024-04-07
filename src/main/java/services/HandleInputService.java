/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import constant.Constant;
/**
 *
 * @author PC
 */
public class HandleInputService {
    BitDataProccesser handleBit;
    Constant constant;
    int[] IP;
    int[] ExtendRigth;
    int[][] SBox;
    int[] P;
    int[] InverseP;
    public HandleInputService(){
        this.handleBit = new BitDataProccesser();
        this.constant = new Constant();
        this.IP = this.constant.IP;
        this.ExtendRigth = this.constant.ExtendRigth;
        this.SBox = new int[][] {this.constant.SBox1, this.constant.Sbox2, this.constant.Sbox3, this.constant.Sbox4, this.constant.Sbox5, this.constant.Sbox6, this.constant.Sbox7, this.constant.Sbox8};
        this.P = this.constant.P;
        this.InverseP = this.constant.InverseP;
    }
    
    public String handleInputText(String input, String[] key){
        System.out.println("start handle text");
        String IPtext = this.handleBit.permulation(input, this.IP);
        System.out.println(this.handleBit.convertBinToHex(IPtext));
        String left = IPtext.substring(0, IPtext.length()/2);
        String rigth = IPtext.substring(IPtext.length()/2, IPtext.length());
        for(int i=0; i< 16;i++) {
            String tempLeft = left;
            System.out.println("permulation rigth");
            String rigthProcess = this.handleBit.permulation(rigth, this.ExtendRigth);
            System.out.println(this.handleBit.convertBinToHex(rigthProcess));
            System.out.println(this.handleBit.convertBinToHex(key[i]));
            rigthProcess = this.handleBit.XORCalc(rigthProcess, key[i]);
            System.out.println("XOR key vs rigth extend");
            System.out.println(this.handleBit.convertBinToHex(rigthProcess));
            String SBoxValue = this.handleBit.SBoxPermulation(rigthProcess, this.SBox);
            System.out.println(SBoxValue);
            System.out.println(this.handleBit.convertBinToHex(SBoxValue));
            String finalValue = this.handleBit.permulation(SBoxValue, this.P);
            System.out.println("P permulation");
            System.out.println(this.handleBit.convertBinToHex(finalValue));
            left = rigth;
            rigth = this.handleBit.XORCalc(tempLeft, finalValue);
            
            System.out.println("RIGHT");
            System.out.println(i);
            System.out.println(this.handleBit.convertBinToHex(this.handleBit.XORCalc(tempLeft, finalValue)));
            System.out.println("LEFT");
            System.out.println(this.handleBit.convertBinToHex(left));
        }
        String frigh = rigth;
        System.out.println(this.handleBit.convertBinToHex(rigth));
        String finalRet = rigth + left;
        System.out.println("FINALLY");
        System.out.println(finalRet);
        System.out.println(this.handleBit.convertBinToHex(this.handleBit.permulation(finalRet, this.InverseP)));
        return this.handleBit.permulation(finalRet, this.InverseP);
    }
}

