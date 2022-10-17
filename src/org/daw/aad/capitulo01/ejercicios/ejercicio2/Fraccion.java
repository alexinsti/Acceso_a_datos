/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio2;

/**
 *
 * @author alejandro
 */
public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
    public Fraccion(String fraccionConBarra) {
        String[] partes=new String[2];
        int numeros[]=new int[2];
        partes= fraccionConBarra.split("/");
        
        for(int i=0;i<partes.length;i++){
            numeros[i]=Integer.parseInt(partes[i]);
            
            if(i+1%2!=0){
                System.out.println("Numerador: "+numeros[i]);
            }else{
                System.out.println("Denominador: "+numeros[i]);
            }
            
            
        }
        
        this.numerador = numeros[0];
        this.denominador = numeros[1];
    }
    
    
}
