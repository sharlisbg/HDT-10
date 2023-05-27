import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;


import org.junit.Test;

import java.lang.Exception;


public class PruebasJUnit {

    private int[][] distancias;
    private String[][] recorridos;
    private FloydWarshall floydWarshall;

    @Before
    public void setUp() {
        distancias = new int[][]{
                {0, 5, 2},
                {5, 0, 7},
                {2, 7, 0}
        };

        recorridos = new String[][]{
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"}
        };

        floydWarshall = new FloydWarshall(distancias, recorridos, 3);
    }

    @Test
    public void testInterrumpirConexion() {
        floydWarshall.interrumpirConexion("A", "B");
        int[][] expectedDistancias = new int[][]{
                {0, Integer.MAX_VALUE, 2},
                {Integer.MAX_VALUE, 0, 7},
                {2, 7, 0}
        };
        Assert.assertArrayEquals(expectedDistancias, floydWarshall.getDistancias());
    }

    @Test
    public void testEstablecerConexion() {
        floydWarshall.establecerConexion("A", "B", 10);
        int[][] expectedDistancias = new int[][]{
                {0, 10, 2},
                {10, 0, 7},
                {2, 7, 0}
        };
        Assert.assertArrayEquals(expectedDistancias, floydWarshall.getDistancias());
    }

    @Test
    public void testEstablecerClima() {
        floydWarshall.establecerClima("A", "B", "lluvia");
        int[][] expectedDistancias = new int[][]{
                {0, 2, 2},
                {2, 0, 7},
                {2, 7, 0}
        };
        Assert.assertArrayEquals(expectedDistancias, floydWarshall.getDistancias());
    }

    @Test
    public void testRecalcularCentroGrafo() {
        floydWarshall.recalcularCentroGrafo();
        
    }


    @Test
	void testCalcularRutas() {
		int[][] matriz_distancias = {{0,4,8,10000,10000},
				{4,0,1,2,10000},
				{8,10000,0,4,2},
				{10000,2,4,0,7},
				{10000,10000,2,7,0}};
		
		String[][] matriz_recorridos = 
			{{"A","B","C","D","E"},
					{"A","B","C","D","E"},
					{"A","B","C","D","E"},
					{"A","B","C","D","E"},
					{"A","B","C","D","E"}};
		
		FloydWarshall algoritmoFW = new FloydWarshall(matriz_distancias, matriz_recorridos, 5);

		algoritmoFW.CalcularRutas();
		
		int[][] matriz_distancias_resultante = 
			{{0,4,5,6,7},
				{4,0,1,2,3},
				{8,6,0,4,2},
				{6,2,3,0,5},
				{10,8,2,6,0}};
		
		
		String[][] matriz_recorridos_resultante = 
			{{"A","B","B","B","C"},
					{"A","B","C","D","C"},
					{"A","D","C","D","E"},
					{"B","B","B","D","C"},
					{"C","D","C","C","E"}};
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				assertEquals(matriz_distancias_resultante[i][j], 
						algoritmoFW.getDistancias()[i][j]);
			}
		}
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				assertEquals(matriz_recorridos_resultante[i][j], 
						algoritmoFW.getRecorridos()[i][j]);
			}
		}
	}
}
