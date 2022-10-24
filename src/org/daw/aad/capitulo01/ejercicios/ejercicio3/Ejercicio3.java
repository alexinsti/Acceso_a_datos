/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio3;

import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author alejandro
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta="src//org//daw//aad//capitulo01//ejercicios//ejercicio3//diccionario.txt";
        String rutaBinario="src//org//daw//aad//capitulo01//ejercicios//ejercicio3//guardadoBinario.txt";
        Diccionario diccionario= new Diccionario();
        diccionario.importar(ruta);
        diccionario.guardar(rutaBinario);
        
        System.out.println(diccionario.get("a priori"));
        
        //diccionario.reversa("a priori");
        //diccionario.buscarInversa("priori");
      
        System.out.println();
        
    }
    
}
