/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author PC
 */
public class FileController {
    public FileController() {}
    
    public void writeFile(String file, String text){
        try {
            PrintWriter pw = new PrintWriter(file,"UTF-8");
            pw.println(text);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String readFile(File f) {
        String ret = "";
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while(true) {
                line = br.readLine();
                if(line == null) break;
                else {
                    ret += line;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("File:");
        System.out.println(ret);
        return ret;
    }
}
