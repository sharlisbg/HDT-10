/**
 * 
 */
//package edu.uvg.graphs;

/**
 * @author MAAG
 *
 */

import java.util.Arrays;

public class Floyd_modificado {

    private int[][] distancias;
    private String[][] recorridos;
    private String[] vertices;
    private int SIZE;

    public Floyd_modificado(int[][] _distancias, String[][] _recorridos, int matriz_size) {
        SIZE = matriz_size;
        distancias = _distancias;
        recorridos = _recorridos;
        vertices = new String[matriz_size];
        for (int i = 0; i < matriz_size; i++) {
            vertices[i] = _recorridos[0][i];
        }
    }

    /**
	 * @return the distancias
	 */
    public int[][] getDistancias() {
        return distancias;
    }

    /**
	 * @param distancias the distancias to set
	 */
    public void setDistancias(int[][] distancias) {
        this.distancias = distancias;
    }

    /**
	 * @return the recorridos
	 */
    public String[][] getRecorridos() {
        return recorridos;
    }

    /**
	 * @param recorridos the recorridos to set
	 */
    public void setRecorridos(String[][] recorridos) {
        this.recorridos = recorridos;
    }

    /**
	 * @return the sIZE
	 */
    public int getSIZE() {
        return SIZE;
    }

    /**
	 * @param sIZE the sIZE to set
	 */
    public void setSIZE(int sIZE) {
        SIZE = sIZE;
    }

 
    public void CalcularRutas() {
        for (int i = 0; i < SIZE; i++) { //Que fila y que columna trabajo
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    if ((i != j) && (i != k)) {
                        int suma = distancias[j][i] + distancias[i][k];
                        if (suma < distancias[j][k]) {
                            distancias[j][k] = suma;
                            recorridos[j][k] = vertices[i];
                        }
                    }
                }
            }
        }
    }

       /**
	 * Calcula el centro del grafo 
	 */
    public void CalcularCentroGrafo() {
        int[] maxDistancias = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            int maxDistancia = Integer.MIN_VALUE;
            for (int j = 0; j < SIZE; j++) {
                if (distancias[i][j] > maxDistancia) {
                    maxDistancia = distancias[i][j];
                }
            }
            maxDistancias[i] = maxDistancia;
        }

         // Calcula la máxima distancia para cada vértice
        int minMaxDistancia = Integer.MAX_VALUE;
        int centro = -1;
        for (int i = 0; i < SIZE; i++) {
            if (maxDistancias[i] < minMaxDistancia) {
                minMaxDistancia = maxDistancias[i];
                centro = i;
            }
        }

        System.out.println("El centro del grafo es el vértice: " + vertices[centro]);
    }

    public void interrumpirConexion(String ciudad1, String ciudad2) {
        int indiceCiudad1 = Arrays.asList(vertices).indexOf(ciudad1);
        int indiceCiudad2 = Arrays.asList(vertices).indexOf(ciudad2);
        distancias[indiceCiudad1][indiceCiudad2] = Integer.MAX_VALUE;
        distancias[indiceCiudad2][indiceCiudad1] = Integer.MAX_VALUE;
    }

    public void establecerConexion(String ciudad1, String ciudad2, int tiempo) {
        int indiceCiudad1 = Arrays.asList(vertices).indexOf(ciudad1);
        int indiceCiudad2 = Arrays.asList(vertices).indexOf(ciudad2);
        distancias[indiceCiudad1][indiceCiudad2] = tiempo;
        distancias[indiceCiudad2][indiceCiudad1] = tiempo;
    }

    public void establecerClima(String ciudad1, String ciudad2, String clima) {
        int indiceCiudad1 = Arrays.asList(vertices).indexOf(ciudad1);
        int indiceCiudad2 = Arrays.asList(vertices).indexOf(ciudad2);
        
        // Asignar tiempo en función del clima
        int tiempo = 0;
        if (clima.equals("lluvia")) {
            tiempo = 2;
        } else if (clima.equals("nieve")) {
            tiempo = 4;
        } else if (clima.equals("tormenta")) {
            tiempo = 6;
        }
        
        distancias[indiceCiudad1][indiceCiudad2] = tiempo;
        distancias[indiceCiudad2][indiceCiudad1] = tiempo;
    }

    public void recalcularCentroGrafo() {
        CalcularRutas();
        CalcularCentroGrafo();
    }
}
