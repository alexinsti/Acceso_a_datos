/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author alejandro
 */
public class Agenda{
    
    private ContactoBuilder contactoBuilder;
    public List<Contacto> contactos;
    
    
    public void setContactoBuilder(ContactoBuilder cb){
        contactoBuilder=cb;
    }
    
    public Contacto getContacto(){
        Contacto resultado=contactoBuilder.getContacto();
        
        return resultado;
    }

    public Agenda(ContactoBuilder contactoBuilder) {
        this.contactoBuilder = contactoBuilder;
    }
    
    public void generaContacto(){
        contactoBuilder.crearNuevoContacto();
        contactoBuilder.buildSexo();
        contactoBuilder.buildNombre();
        contactoBuilder.buildApellido1();
        contactoBuilder.buildApellido2();
        contactoBuilder.buildGrupo();
        contactoBuilder.buildDestacado();
        contactoBuilder.buildLatitud();
        contactoBuilder.buildLongitud();
        contactoBuilder.buildNivel();
        contactoBuilder.buildFechaNacimiento();
        contactoBuilder.buildTelefono();
    }

    public Agenda() {
        contactos= new ArrayList<Contacto>();
    }
    
    public boolean insertar(Contacto contacto){
        boolean resultado=true;
        for(Contacto c : contactos){
            if(contacto.equals(c)){
                resultado=false;
            }else{
                contactos.add(contacto);
            }
        }
        
        return resultado;
    }
    
    public boolean eliminar(Contacto contacto){
        boolean resultado=true;
        for(Contacto c : contactos){
            if(contacto.equals(c)){
                contactos.remove(contacto);
            }else{
                resultado=false;
            }
        }
        
        return resultado;
    
    }

  
    public void listar(int desde, int hasta){
        contactos.stream()
                //.skip(desde-1)
                //.limit(hasta)
                //.peek(x->System.out.print("he entrado al list por "+x.toString()))
                .forEach(x -> {System.out.println("hola");});
       
    }
}
//System.out.println(x.getNombre()+" "+x.getApellido1()+" "+x.getApellido2()+" "+x.getTelefono());