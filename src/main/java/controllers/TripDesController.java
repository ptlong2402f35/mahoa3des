/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.Key;
import models.TextElement;
/**
 *
 * @author PC
 */
public class TripDesController {
    Key key;
    DesController des;
    String key1;
    String key2;
    String key3;
    TextElement TE;
    
    public TripDesController() {
        this.key = new Key();
        this.des = new DesController();
        this.TE = new TextElement();
        this.init();
    }
    
    public TripDesController(String[] keys) {
        this.key = new Key(keys);
        this.des = new DesController();
        this.TE = new TextElement();
        this.init();
    }
    
    
    public void init(){
        String[] keys = this.key.getKeys();
        String key1 = this.TE.convertElementToBinary(keys[0]);
        String key2 = this.TE.convertElementToBinary(keys[1]);
        String key3 = this.TE.convertElementToBinary(keys[2]);
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }
    
    public String encrypt(String input) {
        String output = "";
        output = this.des.encrypt(input, this.key1);
        output = this.des.decrypt(output, this.key2);
        output = this.des.encrypt(output, this.key3);
        return output;
    }
    
    public String decrypt(String input) {
        String output = "";
        output = this.des.decrypt(input, this.key3);
        output = this.des.encrypt(output, this.key2);
        output = this.des.decrypt(output, this.key1);
        return output;
    }
}
