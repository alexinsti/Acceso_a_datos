/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo01.aadcapitulo1b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damm
 */
public class AADCapitulo1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        BufferedReader lectura= null;
        String fichero= "carpeta//fichero.txt";
        
        try {
            lectura=new BufferedReader(new FileReader(fichero));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                lectura.close();
            } catch (IOException ex) {
                Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        
        
        String fichero= "carpeta//fichero.txt";
        
        try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
            
            //TRatamiento de la lectura
            while(lectura.ready()){
                System.out.println(lectura.readLine());
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
