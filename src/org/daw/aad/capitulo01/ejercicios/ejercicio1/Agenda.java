/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

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
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;
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
    
    public void generarContacto(){
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
        
        if(contactos.isEmpty()){
        }else{
            for(Contacto c : contactos){ 
                if(contacto.compareTo(c)==0){
                    resultado=false;
                }
            }
        }
        if(resultado==true)
            contactos.add(contacto);
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
        
        //para que funcione aunque metan el intervalo al reves invierto el principio y el final si el principio es mayor que el final
        if(desde>hasta){
            int aux;
            aux=desde;
            desde=hasta;
            hasta=aux;
        }
        contactos.stream()
                .skip(desde-1)
                .limit(hasta-desde+1)//porque como tienes una nueva lista tienes que contemplar lo que desplazas los indices al skipear 
                .forEach(x -> {System.out.println(x.getNombre()+" "+x.getApellido1()+" "+x.getApellido2()+" "+x.getTelefono());System.out.println(";");});
    }

    void listaDetalle(int desde, int hasta) {
        //para que funcione aunque metan el intervalo al reves invierto el principio y el final si el principio es mayor que el final
        if(desde>hasta){
            int aux;
            aux=desde;
            desde=hasta;
            hasta=aux;
        }
        contactos.stream()
                .skip(desde-1)
                .limit(hasta-desde+1)//porque como tienes una nueva lista tienes que contemplar lo que desplazas los indices al skipear 
                .forEach(x -> {System.out.println(x.toString());});
        
       
    }
    
    public void generarDatos(int cantidad){
        for(int i=0; i<cantidad; i++){
            int selector=(int)(Math.random()*5);
            switch (selector){
                case 0:
                    ContactoBuilder contactoFamiliar= new FamiliaresContactoBuilder();
                    setContactoBuilder(contactoFamiliar);
                    break;
                case 1:
                    ContactoBuilder contactoAmigos= new AmigosContactoBuilder();
                    setContactoBuilder(contactoAmigos);
                    break;
                case 2:
                    ContactoBuilder contactoTrabajo= new TrabajoContactoBuilder();
                    setContactoBuilder(contactoTrabajo);
                    break;
                case 3:
                    ContactoBuilder contactoEmergencia= new EmergenciaContactoBuilder();
                    setContactoBuilder(contactoEmergencia);
                    break;
                case 4:
                    ContactoBuilder contactoOtros= new OtrosContactoBuilder();
                    setContactoBuilder(contactoOtros);
                    break;
            
            }
            
            generarContacto();
            insertar(contactoBuilder.getContacto());
        }
        
    }
    
    public void guardarTexto(String fichero){
        try {
            PrintStream salida = new PrintStream(new File(fichero));
            PrintStream consola=System.out;
            System.setOut(salida);
            listaDetalle(1, Integer.MAX_VALUE);
            System.setOut(consola);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void cargarTexto(String fichero){
    
        String linea= "";
        
        try(BufferedReader lectura=new BufferedReader(new FileReader(fichero))) {
            
            //TRatamiento de la lectura
            while(lectura.ready()){
                linea=lectura.readLine();
                String[] datosContacto=linea.split(";");
                insertar(new Contacto(datosContacto[0],
                                    datosContacto[1],
                                    datosContacto[2],
                                    datosContacto[3],
                                    Contacto.Grupo.valueOf(datosContacto[4]),
                                    LocalDate.parse(datosContacto[5]),
                                    Contacto.Sexo.valueOf(datosContacto[6]),
                                    Double.valueOf(datosContacto[7]),
                                    Double.valueOf(datosContacto[8]),
                                    Boolean.valueOf(datosContacto[9]),
                                    Integer.valueOf(datosContacto[10])));
                System.out.println(lectura.readLine());
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void guardarBinario(String fichero){
        
        try(DataOutputStream streamBinarioEscritura = new DataOutputStream(new FileOutputStream(fichero))){
            contactos.stream()
                    .forEach(x -> {
                        try {
                            streamBinarioEscritura.writeUTF(x.getNombre());
                            streamBinarioEscritura.writeUTF(x.getApellido1());
                            streamBinarioEscritura.writeUTF(x.getApellido2());
                            streamBinarioEscritura.writeUTF(x.getTelefono());
                            streamBinarioEscritura.writeUTF(x.getGrupo().name());
                            streamBinarioEscritura.writeUTF(x.getFechaNacimiento().toString());
                            streamBinarioEscritura.writeUTF(x.getSexo().name());
                            streamBinarioEscritura.writeDouble(x.getLatitud());
                            streamBinarioEscritura.writeDouble(x.getLongitud());
                            streamBinarioEscritura.writeBoolean(x.getDestacado());
                            streamBinarioEscritura.writeInt(x.getNivel());
                            
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void cargarBinario(String fichero){
        
        try(DataInputStream streamBinarioLectura=new DataInputStream(new FileInputStream(fichero))){
        
            while(true){
                insertar(new Contacto(streamBinarioLectura.readUTF(),
                                    streamBinarioLectura.readUTF(),
                                    streamBinarioLectura.readUTF(),
                                    streamBinarioLectura.readUTF(),
                                    Contacto.Grupo.valueOf(streamBinarioLectura.readUTF()),
                                    LocalDate.parse(streamBinarioLectura.readUTF()),
                                    Contacto.Sexo.valueOf(streamBinarioLectura.readUTF()),
                                    streamBinarioLectura.readDouble(),
                                    streamBinarioLectura.readDouble(),
                                    streamBinarioLectura.readBoolean(),
                                    streamBinarioLectura.readInt()));
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            System.out.println("he llegado al final");
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    public void guardarObjeto(String fichero){
    
        try(ObjectOutputStream streamSerializadoEscritura=new ObjectOutputStream(new FileOutputStream(fichero))){
            
                    for(Contacto c : contactos){
                        try {
                                streamSerializadoEscritura.writeObject(c);
                            } catch (IOException ex) {
                                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                        
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargarObjeto(String fichero){
    
        try(ObjectInputStream streamSerializadoLectura=new ObjectInputStream(new FileInputStream(fichero)) ){
        
            while(true){
                try {
                    contactos.add((Contacto) streamSerializadoLectura.readObject());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            System.out.println("he llegado al final");
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void exportarHTML(String fichero){
        try {
            PrintStream salida = new PrintStream(new File(fichero));
            PrintStream consola=System.out;
            System.setOut(salida);
            System.out.println("<!DOCTYPE html>\n" +
                                    "<html>\n" +
                                    "    <head>\n" +
                                    "        <title>Ejercicio tablas</title>\n" +
                                    "    </head>\n" +
                                    "\n" +
                                    "    <body>");
            System.out.println("<table>");
            contactos.stream()
                    .forEach(x -> {
                        System.out.println("<tr>");
                            System.out.println("<td>");
                            System.out.println(x.getNombre());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getApellido1());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getApellido2());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getTelefono());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getGrupo().name());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getFechaNacimiento().toString());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getSexo().name());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getLatitud());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getLongitud());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getDestacado());
                            System.out.println("</td>");
                            
                            System.out.println("<td>");
                            System.out.println(x.getNivel());
                            System.out.println("</td>");
                        System.out.println("</tr>");
                    
                    });
            System.out.println("</table>");
            
            
            System.out.println(     "   </body>\n" +
                                    "\n" +
                                    "</html>");
            System.setOut(consola);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Optional<List<Contacto>> buscar(Predicate<Contacto> criterio){
        Optional<List<Contacto>> resultado;
        
        resultado= Optional.of(contactos.stream()
                .filter(criterio)
                .collect(toList()));
        return resultado;
    }
    
    public void crearCarpetas(){

        contactos.stream()
                .forEach(x -> {
                    
                    try {
                        PrintStream salida;
                        String ruta="src//org//daw//aad//capitulo01//ejercicios//ejercicio1";
                        String nombreFichero=x.getApellido1()+"_"+x.getApellido2()+"_"+x.getNombre();
                        File carpeta = new File(ruta, nombreFichero);
                        carpeta.mkdir();

                        salida = new PrintStream(ruta+"//"+nombreFichero+"//datos");
                        PrintStream consola=System.out;
                        System.setOut(salida);

                        Stream<Contacto> stream2=contactos.stream();
                        stream2.forEach(y -> {
                                        
                                        if(y.compareTo(x)==0){
                                            System.out.println(y.toString());
                                        }
                                        
                                        });
                        stream2.close();

                        System.setOut(consola);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
    }


}
