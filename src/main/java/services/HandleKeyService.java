/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import constant.Constant;
/**
 *
 * @author ptlong2402
 */
public class HandleKeyService {
    BitDataProccesser handleBit;
    Constant constant;
    int[] PC1;
    int[] PC2;
    int[] RotLeftShift;
    public HandleKeyService() {
        this.handleBit = new BitDataProccesser();
        this.constant = new Constant();
        this.PC1 = this.constant.PC1;
        this.PC2 = this.constant.PC2;
        this.RotLeftShift = this.constant.RotLeftShift;
    } 
    
    public String[] handleKey(String key) {
        String[] ret = new String[16];
        String PC1Key = this.handleBit.permulation(key, this.PC1);
        String leftKey = PC1Key.substring(0,7*4);
        String rigthKey = PC1Key.substring(7*4,7*8);
        for(int i=0; i< ret.length;i++) {
            leftKey = this.handleBit.leftShift(leftKey, this.RotLeftShift[i]);
            rigthKey = this.handleBit.leftShift(rigthKey, this.RotLeftShift[i]);
            String combineKey = leftKey + rigthKey;
            String retKey = this.handleBit.permulation(combineKey, this.PC2);
            ret[i] = retKey;
        }
        return ret;
    }
}
