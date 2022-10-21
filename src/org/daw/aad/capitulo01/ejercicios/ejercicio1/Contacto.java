/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author alejandro
 */
public class Contacto implements Comparable<Contacto>, Serializable{
 
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;

    Contacto() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int compareTo(Contacto o) {
        int resultado=-1;
        if(apellido1.equals(o.apellido1)&&apellido2.equals(o.apellido2)&&nombre.equals(o.nombre)){
            resultado=0;
        }
        return resultado;
    }
    public enum Grupo{FAMILIARES, AMIGOS, TRABAJO, EMERGENCIA, OTROS}
    private Grupo grupo;
    private LocalDate fechaNacimiento;
    public enum Sexo{HOMBRE, MUJER, NOSLECCIONADO};
    private Sexo sexo;
    private double latitud;
    private double longitud;
    private boolean destacado;
    private int nivel;

    public Contacto(String nombre, String apellido1, String apellido2, String telefono, Grupo grupo, LocalDate fechaNacimiento, Sexo sexo, double latitud, double longitud, boolean destacado, int nivel) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.grupo = grupo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.destacado = destacado;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if(nivel>10){
            this.nivel=10;
        }else if(nivel<1){
            this.nivel=1;
        }else{
            this.nivel = nivel;
        }
        
    }
    
    public String toString(){
        String resultado="";
        
        resultado+=nombre+"\n";
        resultado+=apellido1+"\n";
        resultado+=apellido2+"\n";
        resultado+=telefono+"\n";
        resultado+=grupo.toString()+"\n";
        resultado+=fechaNacimiento.toString()+"\n";
        resultado+=sexo.toString()+"\n";
        resultado+=Double.toString(latitud)+"\n";
        resultado+=Double.toString(longitud)+"\n";
        resultado+=Boolean.toString(destacado)+"\n";
        resultado+=Integer.toString(nivel)+"\n";
        
        return resultado;
    }
    
    
}
