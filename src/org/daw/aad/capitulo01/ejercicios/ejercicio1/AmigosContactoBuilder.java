/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.daw.aad.capitulo01.ejercicios.ejercicio1;

/**
 *
 * @author alejandro
 */
public class AmigosContactoBuilder extends ContactoBuilder{

    @Override
    public void buildGrupo() {
        contacto.setGrupo(Contacto.Grupo.AMIGOS);
    }
    
}
