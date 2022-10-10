/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.daw.aad.capitulo1cStreams;

import java.util.Collections;
import java.util.stream.Stream;

/**
 *
 * @author damm
 */
public class Streams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Stream <Integer> numeros = Stream.of(-13, -1,5,6,3,4, 69, -1,8,3,4,5,-2,6,6,-6);
        
        numeros.filter((x)->(x%2==1)||(x%2==-1))
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(1)
                .limit(3)
                .forEach(System.out::println);
    }
    
}
