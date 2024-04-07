/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
/**
 *
 * @author ptlong2402
 */
public class Key {
    String KEY1DEFAULT = "123abc!@";
    String KEY2DEFAULT = "ptw14@24";
    String KEY3DEFAULT = "094zao12";
    
    private String key1;
    private String key2;
    private String key3;
    
    public Key(){
        this.init(KEY1DEFAULT, KEY2DEFAULT, KEY3DEFAULT);
    }
    
    public Key(String[] keys) {
        this.setKey(keys);
    }
    
    public void init(String key1, String key2, String key3) {
         this.key1 = key1;
         this.key2 = key2;
         this.key3 = key3;
    }
    
    public void setKey(String[] keys){
        String key1 = keys[0];
        String key2 = keys[1];
        String key3 = keys[2];
        this.init(key1, key2, key3);
    }
    
    public String[] getKeys(){
       
       return new String[]{this.key1, this.key2, this.key3};
    }
    
    public String[] getBinKeys(String[] keys) {
        String key1 = this.convertToBin(keys[0]);
        String key2 = this.convertToBin(keys[1]);
        String key3 = this.convertToBin(keys[2]);
        return new String[] {key1, key2, key3};
    }
    
    public String convertToBin(String key) {
        String ret = "";
        for(int i =0; i< key.length(); i++) {
                int asciiVal = key.charAt(i);
                String binVal = Integer.toBinaryString(asciiVal);
                while (binVal.length() % 4 != 0) {
                    binVal = "0" + binVal;
                }
                ret+= binVal;
        }
        return ret;
    }
}
