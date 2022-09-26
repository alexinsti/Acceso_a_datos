package org.daw.aad.capitulo01;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class AADCapitulo01 {

    public static void main(String[] args) {

        File directorio = new File("carpeta");
        File origen = new File(directorio, "fichero.txt");
        File destino = new File(directorio, "fichero2.txt");
        String carpeta = "carpeta2";
        String nombreFichero = "fichero.txt";

  /*      
        //Ejercicio 1 crear carpeta a partir de un objeto File
        crearCarpeta(directorio);
        //Ejercicio 2 crear carpeta a partir del nombre en String
        crearCarpeta(carpeta);

        //Ejercicio 3 crear fichero dada un objeto File
        crearFichero(origen);
        //Ejercicio 4 crear fichero dada la ruta
        crearFichero(nombreFichero);
        //Ejercicio 5 crear fichero dada la ruta y el nombre del ficheo
        crearFichero(carpeta, nombreFichero);

        //Ejercicio 6 borrar un fichero dado un objeto File con el nombre del fichero
        borrarFichero(nombreFichero);
        //Ejercicio 7 borrar un fichero dado el nombre en String
        
        //Ejercicio 8 Copiar un fichero
        copiarFichero(origen, destino);

        //Ejercicio 9 Listar contenido de una carpeta
        listarDirectorio("carpeta2");
        //Ejercicio 10 Eliminar una carpeta incluido su contenido (no recursivo)
        eliminarCarpeta("carpeta2");
 */  
//        for (int i = 0; i < 10; i++) {
//            
//        }
        crearFicherosAzar("dir", 3, 15);
        
    }

    /**
     * Ejercicio 1. Crear una carpeta dado un objeto file con el nombre del
     * directorio
     *
     * @param nombreDir Objeto con el nombre de la carpeta
     */
    public static void crearCarpeta(File nombreDir) {

        if (!nombreDir.mkdir() && !nombreDir.exists()) {
            System.err.println("No se ha podido crear el directorio " + nombreDir);
            System.exit(-1);
        }
    }

    /**
     * Ejercicio 2. Crear una carpeta dado el nombre en String
     *
     * @param nombreDir nombre de la carpeta
     */
    public static void crearCarpeta(String nombreDir) {
        crearCarpeta(new File(nombreDir));
    }

    /**
     * Ejercicio 3. Crea un fichero a partir de un objeto File
     *
     * @param nombreFichero Objeto File
     */
    public static void crearFichero(File nombreFichero) {

        try {
            nombreFichero.createNewFile();
        } catch (IOException ex) {
            System.err.println("Error al crear el fichero " + nombreFichero);
            System.exit(-2);
        }
    }

    /**
     * Ejercicio 4. Crea un fichero a partir de una cadena
     *
     * @param nombreFichero nombre del fichero en String
     */
    public static void crearFichero(String nombreFichero) {
        crearFichero(new File(nombreFichero));
    }

    /**
     * Ejercicio 5. Crear un fichero dada la ruta y el nombre del fichero
     *
     * @param ruta directorio dónde se crea el archivo
     * @param nombreFichero el fichero a crear
     */
    public static void crearFichero(String ruta, String nombreFichero) {

        crearCarpeta(ruta);
        crearFichero(new File(new File(ruta), nombreFichero));

    }

    /**
     * Ejercicio 6a. Borra un fichero
     * @param nombreFichero un objeto File
     */
    public static void borrarFichero(File nombreFichero) {
        if (!nombreFichero.delete() && !nombreFichero.exists()) {
            System.err.println("No se ha podido borrar el fichero " + nombreFichero );
            System.exit(-1);
        }
    }
    
    /**
     * Ejercicio 6b. Borra un fichero
     * @param nombreFichero una cadena
     */
    public static void borrarFichero(String nombreFichero) {
        borrarFichero(new File(nombreFichero));
    }
    
    
    /**
     * Ejercicio 7. Lista todos los archivos y carpetas de un directorio
     * @param nombreDir 
     */
    public static void listarDirectorio(String nombreDir){
        File dir = new File(nombreDir);
       
        for(File file: dir.listFiles()){
            System.out.println( file + "\t \t " + file.length() + " bytes" );
        }
    }
    
    
    /**
     * Ejercicio 8. Elimina el contenido de una carpeta y la propia carpeta
     * @param nombreDir 
     */
    public static void eliminarCarpeta(String nombreDir){
        File dir = new File(nombreDir);
        if(dir.exists() && dir.list().length > 0){
            for(File file: dir.listFiles()){
                borrarFichero(file);  
            }
        }
        
        borrarFichero(dir);
        
    }
    

    /**
     * Ejercicio 9. Copiar un fichero en otro
     *
     * @param origen
     * @param destino
     */
    public static void copiarFichero(File origen, File destino) {

        try {
            FileUtils.copyFile(origen, destino);
        } catch (IOException ex) {
            System.err.println("Error al copiar el fichero " + origen + " en " + destino);
            System.exit(-3);
        }
    }
    
    /**
     * Crea ficheros al azar
     * @param dir
     * @param numFicheros
     * @param size 
     */
    public static void crearFicherosAzar(String dir, int numFicheros, int size){
                
        crearCarpeta(dir);
        final String abc = "abcdefghijklmnñopqrstuvwxyz";
        String nombreFich = "";
        
        for (int i = 0; i < numFicheros; i++) {
            for (int j = 0; j < size; j++) {
                int index = (int) (Math.random()*abc.length());
                char letra = abc.charAt(index);
                nombreFich += letra;
            }
            crearFichero(dir, nombreFich);
            nombreFich = "";
  
        }

    }
    
}
