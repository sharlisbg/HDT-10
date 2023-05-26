/**
 * Principal es la clase que interactua con el usuario, tiene como atributo el metodo main
 * @author Leonel Contreras 18797
 * @version 1.0
 */

 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.uvg.graphs.FloydWarshall;

public class Principal {
    public static void main(String[] args) {

        // creamos 4 array bidimensionales, una para cada condicion de clima
        // buenosaires, saopaulo, lima, quito
        int[][] tiemponormal =  new int[4][4];

        int[][] tiempolluvia =  new int[4][4];
  
        int[][] tiemponieve =  new int[4][4];
  
        int[][] tiempotormenta =  new int[4][4];

       BufferedReader reader = null;
        ArrayList<String> partsList = new ArrayList<>();
        
        try {
            // Provide the path to your text file
            String filePath = "logistica.txt";
            
            // Create a BufferedReader object to read the file
            reader = new BufferedReader(new FileReader(filePath));
            
            String line;
            
            // Read each line of the file until the end
            while ((line = reader.readLine()) != null) {
                // Split the line by blank spaces
                String[] parts = line.split(" ");
                
                // Add each split part to the ArrayList
                for (String part : parts) {
                    partsList.add(part);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedReader in the finally block
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Print the contents of the ArrayList
        /*for (String part : partsList) {
            System.out.println(part);
        }*/

        // llenamos la matriz de pesos en tiempo NORMAL
        //System.out.println("NORMAL");
        tiemponormal[0][1] = Integer.parseInt(partsList.get(2));
        tiemponormal[0][3] = 1000000;
        tiemponormal[0][2] = Integer.parseInt(partsList.get(8));
        tiemponormal[1][0] = 1000000;
        tiemponormal[1][2] = 1000000;
        tiemponormal[1][3] = 1000000;
        tiemponormal[2][0] = 1000000;
        tiemponormal[2][1] = 1000000;
        tiemponormal[2][3] = Integer.parseInt(partsList.get(14));
        tiemponormal[3][0] = 1000000;
        tiemponormal[3][1] = 1000000;
        tiemponormal[3][2] = 1000000;

        // llenamos la matriz de recorridos para tiempo NORMAL
       
        String[][] matrizrecorridosnormal = {{"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}};
        
        /*// Print the resulting array
        for (int i = 0; i < tiemponormal.length; i++) {
            for (int j = 0; j < tiemponormal[i].length; j++) {
                System.out.print(tiemponormal[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < matrizrecorridosnormal.length; i++) {
            for (int j = 0; j < matrizrecorridosnormal[i].length; j++) {
                System.out.print(matrizrecorridosnormal[i][j] + " ");
            }
            System.out.println();
        }*/

         // llenamos la matriz de pesos en tiempo LLUVIOSO
         //System.out.println("LLUVIA");
         tiempolluvia[0][1] = Integer.parseInt(partsList.get(3));
         tiempolluvia[0][3] = 1000000;
         tiempolluvia[0][2] = Integer.parseInt(partsList.get(9));
         tiempolluvia[1][0] = 1000000;
         tiempolluvia[1][2] = 1000000;
         tiempolluvia[1][3] = 1000000;
         tiempolluvia[2][0] = 1000000;
         tiempolluvia[2][1] = 1000000;
         tiempolluvia[2][3] = Integer.parseInt(partsList.get(15));
         tiempolluvia[3][0] = 1000000;
         tiempolluvia[3][1] = 1000000;
         tiempolluvia[3][2] = 1000000;
 
         // llenamos la matriz de recorridos para tiempo LLUVIOSO
        
         String[][] matrizrecorridoslluvia = {{"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}};
         
        /*  // Print the resulting array
         for (int i = 0; i < tiemponormal.length; i++) {
             for (int j = 0; j < tiempolluvia[i].length; j++) {
                 System.out.print(tiempolluvia[i][j] + " ");
             }
             System.out.println();
         }
         
         for (int i = 0; i < matrizrecorridoslluvia.length; i++) {
             for (int j = 0; j < matrizrecorridoslluvia[i].length; j++) {
                 System.out.print(matrizrecorridoslluvia[i][j] + " ");
             }
             System.out.println();
         }*/

         // llenamos la matriz de pesos en tiempo NIEVE
         //System.out.println("NIEVE");
         tiemponieve[0][1] = Integer.parseInt(partsList.get(4));
         tiemponieve[0][3] = 1000000;
         tiemponieve[0][2] = Integer.parseInt(partsList.get(10));
         tiemponieve[1][0] = 1000000;
         tiemponieve[1][2] = 1000000;
         tiemponieve[1][3] = 1000000;
         tiemponieve[2][0] = 1000000;
         tiemponieve[2][1] = 1000000;
         tiemponieve[2][3] = Integer.parseInt(partsList.get(16));
         tiemponieve[3][0] = 1000000;
         tiemponieve[3][1] = 1000000;
         tiemponieve[3][2] = 1000000;
 
         // llenamos la matriz de recorridos para tiempo NIEVE
        
         String[][] matrizrecorridosnieve = {{"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}};
         
         /*// Print the resulting array
         for (int i = 0; i < tiemponieve.length; i++) {
             for (int j = 0; j < tiemponieve[i].length; j++) {
                 System.out.print(tiemponieve[i][j] + " ");
             }
             System.out.println();
         }
         
         for (int i = 0; i < matrizrecorridosnieve.length; i++) {
             for (int j = 0; j < matrizrecorridosnieve[i].length; j++) {
                 System.out.print(matrizrecorridosnieve[i][j] + " ");
             }
             System.out.println();
         }*/

         // llenamos la matriz de pesos en tiempo TORMENTA
        //System.out.println("TORMENTA");
        tiempotormenta[0][1] = Integer.parseInt(partsList.get(5));
        tiempotormenta[0][3] = 1000000;
        tiempotormenta[0][2] = Integer.parseInt(partsList.get(11));
        tiempotormenta[1][0] = 1000000;
        tiempotormenta[1][2] = 1000000;
        tiempotormenta[1][3] = 1000000;
        tiempotormenta[2][0] = 1000000;
        tiempotormenta[2][1] = 1000000;
        tiempotormenta[2][3] = Integer.parseInt(partsList.get(17));
        tiempotormenta[3][0] = 1000000;
        tiempotormenta[3][1] = 1000000;
        tiempotormenta[3][2] = 1000000;

        // llenamos la matriz de recorridos para tiempo TORMENTA
       
        String[][] matrizrecorridostormenta = {{"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}};
        
       /*  // Print the resulting array
        for (int i = 0; i < tiempotormenta.length; i++) {
            for (int j = 0; j < tiempotormenta[i].length; j++) {
                System.out.print(tiempotormenta[i][j] + " ");
            }
            System.out.println();
        }
        
        for (int i = 0; i < matrizrecorridostormenta.length; i++) {
            for (int j = 0; j < matrizrecorridostormenta[i].length; j++) {
                System.out.print(matrizrecorridostormenta[i][j] + " ");
            }
            System.out.println();
        }*/

        int opcionusuario = 0;
        System.out.println("Ingrese una opcion de condicion climatica");
        System.out.println("1. Condiciones de tiempo normal");
        System.out.println("2. Condiciones de tiempo lluvioso");
        System.out.println("3. Condiciones de tormenta");
        System.out.println("4. Condiciones de nieve");
        System.out.println("5. Salir");
        

        while (opcionusuario != 5) {
            if (opcionusuario ==1) {
                // condiciones normales
                // creamos un objeto de tipo flyod washall para condiciones normales
                FloydWarshall FWnormal = new FloydWarshall(tiemponormal, matrizrecorridosnormal, 4);
                System.out.println("Ingrese una opcion");
                System.out.println("1. Calcular ruta mas corta");
                System.out.println("2. Calcular centro del grafo");
                int seleccion;
            }

            if (opcionusuario == 2) {
                // condiciones de lluvia
                // creamos un objeto tipo FloyWarshall
                FloydWarshall FWlluvia = new FloydWarshall(tiempolluvia, matrizrecorridoslluvia, 4);
            }

            if (opcionusuario == 3) {
                // condiciones de tormenta
                // creamos un objeto tipo FloyWarshall
                FloydWarshall FWtormenta= new FloydWarshall(tiempotormenta, matrizrecorridostormenta, 4);
            }

            if (opcionusuario == 3) {
                // condiciones de nieve
                // creamos un objeto tipo FloydWarshall
                FloydWarshall FWnieve = new FloydWarshall(tiemponieve, matrizrecorridosnieve, 4);
            }
        }

        System.out.println("Usted ha elegido salir. Adios!");
         
    }
}