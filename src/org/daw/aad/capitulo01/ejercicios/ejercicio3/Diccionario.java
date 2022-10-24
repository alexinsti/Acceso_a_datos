/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author alejandro
 */
public class Diccionario {
    Map<String, String> diccionario;
    
    public Diccionario(){
        diccionario=new TreeMap() {};
        
    }
    
    public void importar(String nombreFichero){
        try(BufferedReader lectura=new BufferedReader(new FileReader(nombreFichero))) {
            //TRatamiento de la lectura
            while(lectura.ready()){
                String linea= lectura.readLine();
                String[] arrayLinea= linea.split("->");
                diccionario.put(arrayLinea[0], arrayLinea[1]);
                
                
            }
            
            
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
    }
    
    public String get(String termino){
        String resultado="";
        
        for(Map.Entry<String,String> entry : diccionario.entrySet()){
            if(entry.getKey().equalsIgnoreCase(termino)){
                resultado+=entry.getValue();
            }
        }
        return resultado;
    }
    
    public void guardar(String nombreFichero){
    
        try(DataOutputStream streamBinarioEscritura = new DataOutputStream(new FileOutputStream(nombreFichero))){
            diccionario.entrySet().stream()
                    .forEach(x -> {
                        try {
                            streamBinarioEscritura.writeUTF(x.getKey()+"->"+x.getValue());
                        } catch (IOException ex) {
                            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    
                    });
        
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Diccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    public Optional<List<String>> buscar(Predicate<String> criterio){
        Optional<List<String>> resultado;
        
        resultado= Optional.of(diccionario.keySet().stream()
                                                    .filter(criterio)
                                                    .collect(toList()));
        return resultado;
    }
    
    public void buscarDefiniciones(Predicate<String> criterio){
        diccionario.keySet().stream()
                            .filter(criterio)
                            .forEach(x->{
                                            diccionario.entrySet().stream()
                                                                .forEach(y ->{
                                                                            if(y.equals(x))
                                                                            System.out.println(y.getKey()+"->"+y.getValue());
                                                                        });
                            
                                        });
    
    }
    
    public boolean contiene(String palabra){
        boolean resultado=false;
        if(diccionario.keySet().contains(palabra)) resultado=true;
        
        return resultado;
    }
    
    public void reversa(String palabra){
    
         diccionario.entrySet().stream()
                            .filter(x->x.getKey().equalsIgnoreCase(palabra))
                            .map(x -> x.getValue())
                            .forEach(x->{
                                            String[] palabras=x.split(" ");
                                            
                                            for(String p : palabras){
                                                if(!contiene(p)){
                                                    System.out.println(p+"->No existe definición");
                                                }else{
                                                    System.out.println(p+"->"+get(p));
                                                }
                                                
                                            }
                                            
                                            
                                        });
        
    
    }
    
    public int getNumeroTerminos(){
        int resultado;
        resultado=diccionario.size();
        return resultado;
    }
    
    public void buscarInversa(String palabra){
        diccionario.entrySet().stream()
                                .filter(x -> x.getValue().contains(palabra))
                                .forEach(x -> {
                                                System.out.println(x.getKey()+"->"+x.getValue());
                                            });
    }
    
    public void buscarInversa(Predicate<String> criterio){
        diccionario.values().stream()
                                .filter(criterio)
                                .forEach(x -> {
                                                for(Map.Entry<String,String> entry : diccionario.entrySet()){
                                                    if(entry.getValue().contains(x)){
                                                       System.out.println(entry.getKey()+"->"+entry.getValue()); 
                                                    }
                                                }
                                    
                                                
                                            });
    }
    
}
