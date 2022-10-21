/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

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
public class Ejercicio1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Agenda agenda= new Agenda();
        
        ContactoBuilder contactoFamiliar= new FamiliaresContactoBuilder();
        ContactoBuilder contactoAmigos= new AmigosContactoBuilder();
        ContactoBuilder contactoTrabajo= new TrabajoContactoBuilder();
        ContactoBuilder contactoEmergencia= new EmergenciaContactoBuilder();
        ContactoBuilder contactoOtros= new OtrosContactoBuilder();
        
        agenda.setContactoBuilder(contactoOtros);
        agenda.generaContacto();
        
        Contacto contacto= agenda.getContacto();
        
        System.out.println(contacto.toString());
        
        
       
    }
    
}
