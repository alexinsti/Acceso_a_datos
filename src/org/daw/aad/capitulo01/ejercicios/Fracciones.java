/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.daw.aad.capitulo01.aadcapitulo1b.AADCapitulo1b;

/**
 *
 * @author alejandro
 */
public class Fracciones {
    
    private ArrayList<Fraccion> arrayFracciones= new ArrayList();
    
    
    public void cargaArrayFichero(String ruta){
        
        String linea="";
        String[] fracciones;
        
        try(BufferedReader lectura=new BufferedReader(new FileReader(ruta))) {
            
            //TRatamiento de la lectura
            while(lectura.ready()){
                //System.out.println(lectura.readLine());
                linea=lectura.readLine();
                fracciones=linea.split("[+:-]");
                System.out.println(linea);
                for(String s : fracciones){
                    System.out.println(s);
                    arrayFracciones.add(new Fraccion(s));
                    
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(AADCapitulo1b.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
