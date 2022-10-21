/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public abstract class ContactoBuilder {
    protected Contacto contacto;
    
    public Contacto getContacto(){
        return contacto;
    }
    
    public void crearNuevoContacto(){
        contacto=new Contacto();
    }
    
    public void buildSexo(){
        double n=Math.random();
        if(n<0.3)contacto.setSexo(Contacto.Sexo.HOMBRE);
        else if(n>0.6)contacto.setSexo(Contacto.Sexo.MUJER);
        else contacto.setSexo(Contacto.Sexo.NOSLECCIONADO);
    }
    
    public void buildFechaNacimiento(){
        contacto.setFechaNacimiento(LocalDate.now());
    }
    
    public void buildLatitud(){
        contacto.setLatitud((Math.random()*180)-90);
    }
    
    public void buildLongitud(){
        contacto.setLongitud((Math.random()*360)-180);
    }
    
    public void buildDestacado(){
        if(Math.random()<0.5) contacto.setDestacado(true);
        else contacto.setDestacado(false);
    }
    
    public void buildNivel(){
        contacto.setNivel((int)((Math.random()*10)+1));
    }
    
    
    
    public void buildNombre(){
        int numero=(int)(Math.random()*2);
        if(contacto.getSexo().equals(Contacto.Sexo.HOMBRE)){
               
                String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listadnombresmasculinos.txt";
                
                try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
                    int contador=0;
                    
                    BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
                    int n=(int)(Math.random()*(lectura2.lines().count()));
                    lectura2.close();
                    
                    //TRatamiento de la lectura
                    while(lectura.ready()){
                        lectura.readLine();
                        if(contador==n){
                            contacto.setNombre(lectura.readLine());
                        }
                        contador++;
                    }
                    

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }else if(contacto.getSexo().equals(Contacto.Sexo.MUJER)){
            
            String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listadonombresfemeninos.txt";
                
                try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
                    int contador=0;
                    
                    BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
                    int n=(int)(Math.random()*(lectura2.lines().count()));
                    lectura2.close();
                    
                    //TRatamiento de la lectura
                    while(lectura.ready()){
                        lectura.readLine();
                        if(contador==n){
                            contacto.setNombre(lectura.readLine());
                        }
                        contador++;
                    }
                   

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }else{
            if(numero==0){
        
                String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listadnombresmasculinos.txt";
                
                try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
                    int contador=0;
                    
                    BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
                    int n=(int)(Math.random()*(lectura2.lines().count()));
                    lectura2.close();
                    
                    //TRatamiento de la lectura
                    while(lectura.ready()){
                        lectura.readLine();
                        if(contador==n){
                            contacto.setNombre(lectura.readLine());
                        }
                        contador++;
                    }
                   

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                        Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }else{
                
                String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listadonombresfemeninos.txt";
                
                try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
                    int contador=0;
                    
                    BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
                    int n=(int)(Math.random()*(lectura2.lines().count()));
                    lectura2.close();
                            
                    //TRatamiento de la lectura
                    while(lectura.ready()){
                        lectura.readLine();
                        if(contador==n){
                            contacto.setNombre(lectura.readLine());
                        }
                        contador++;
                    }
                    

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                    Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        }
        
    }
    
    public void buildApellido1(){
        
        String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listaapellidos.txt";
                
        try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
            int contador=0;

            BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
            int n=(int)(Math.random()*(lectura2.lines().count()));
            lectura2.close();

            //TRatamiento de la lectura
            while(lectura.ready()){
                lectura.readLine();
                if(contador==n){
                    contacto.setApellido1(lectura.readLine());
                }
                contador++;
            }
            lectura.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void buildApellido2(){
        
        String fichero= "src//org//daw//aad//capitulo01//ejercicios//ejercicio1//listaapellidos.txt";
                
        try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
            int contador=0;

            BufferedReader lectura2=new BufferedReader(new FileReader(fichero));
            int n=(int)(Math.random()*(lectura2.lines().count()));
            lectura2.close();

            //TRatamiento de la lectura
            while(lectura.ready()){
                lectura.readLine();
                if(contador==n){
                    contacto.setApellido2(lectura.readLine());
                }
                contador++;
            }
            lectura.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ContactoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void buildTelefono(){
        int numero=(int) (Math.random()*1000000000);
        contacto.setTelefono(Integer.toString(numero)); 
    }
    
    public abstract void buildGrupo();
    
}
