/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.daw.aad.capitulo01.aadcapitulo1b.AADCapitulo1b;

/**
 *
 * @author alejandro
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta= "carpeta//ejercicio2.txt";
        Fracciones fracciones= new Fracciones();
        fracciones.cargaArrayFichero(ruta);
        
    }
    
}
