/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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
        String ruta="src//org//daw//aad//capitulo01//ejercicios//ejercicio1//guardadoDatos.csv";
        String rutaBinario="src//org//daw//aad//capitulo01//ejercicios//ejercicio1//guardadoDatosBinario.txt";
        String rutaSerializado="src//org//daw//aad//capitulo01//ejercicios//ejercicio1//guardadoSerializado.txt";
        String rutaHtml="src//org//daw//aad//capitulo01//ejercicios//ejercicio1//tablaHtml.html";
        
        ContactoBuilder contactoFamiliar= new FamiliaresContactoBuilder();
        ContactoBuilder contactoAmigos= new AmigosContactoBuilder();
        ContactoBuilder contactoTrabajo= new TrabajoContactoBuilder();
        ContactoBuilder contactoEmergencia= new EmergenciaContactoBuilder();
        ContactoBuilder contactoOtros= new OtrosContactoBuilder();
        
        agenda.setContactoBuilder(contactoOtros);
        agenda.generarContacto();
        Contacto contacto= agenda.getContacto();
        
        agenda.generarContacto();
        //Contacto contacto2= agenda.getContacto();
        
        agenda.generarDatos(5);
       /* System.out.println(contacto.toString());
        System.out.println(contacto2.toString());
              
        agenda.insertar(contacto);
        agenda.insertar(contacto2);
        
        Optional<List<Contacto>> opcional;
        Predicate<Contacto> predicado= x ->x.getNivel()>5;
        opcional=agenda.buscar(predicado);
        opcional.toString();
        
        agenda.listar(1, 1);
        agenda.listaDetalle(2, 2);*/
        //agenda.insertar(contacto);
        //agenda.cargarTexto(ruta);
        //agenda.cargarBinario(rutaBinario);
        System.out.println("automaticos");
        agenda.listar(1, 5);
        agenda.listaDetalle(1, Integer.MAX_VALUE);
        //agenda.guardarTexto(ruta);
        //agenda.guardarBinario(rutaBinario);
        agenda.guardarObjeto(rutaSerializado);
        agenda.exportarHTML(rutaHtml);
        System.out.println(agenda.contactos.toString());
        
        agenda.crearCarpetas();
        
        
        
        
   
        

    }
    
}
