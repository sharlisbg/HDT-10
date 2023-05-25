/**
 * Principal es la clase que interactua con el usuario, tiene como atributo el metodo main
 * @author Leonel Contreras 18797
 * @version 1.0
 */

 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

        // llenamos la matriz de pesos en tiempo normal
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

        // llenamos la matriz de recorridos
       
        String[][] matrizrecorridosnormal = {{"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}, {"BuenosAires", "SaoPaulo", "Lima", "Quito"}};
        
        // Print the resulting array
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
        }
    }
}