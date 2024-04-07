/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import services.HandleKeyService;
import services.HandleInputService;
import models.TextElement;
import services.BitDataProccesser;
/**
 *
 * @author ptlong2402
 */
public class DesController {
    String key;
    HandleKeyService keyService;
    HandleInputService inputService;
    TextElement text;
    BitDataProccesser handleBit;
    public DesController(){
        this.keyService = new HandleKeyService();
        this.inputService = new HandleInputService();
        this.text = new TextElement();
        this.handleBit = new BitDataProccesser();
    }
    public String encrypt(String input, String key){
        System.out.println(key);
        String[] keys = this.keyService.handleKey(key);
        String ret = this.inputService.handleInputText(input, keys);
        return ret;
    }
    
    public String decrypt(String input, String key) {
        String[] keys = this.keyService.handleKey(key);
        String[] reverseKeys = new String[keys.length];
        for(int i=0; i< keys.length; i++) {
            reverseKeys[i] = keys[keys.length - i - 1];
        }
        String ret = this.inputService.handleInputText(input, reverseKeys);
        return ret;
    }
}
