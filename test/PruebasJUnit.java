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
        // Realizar las aserciones necesarias
    }
}
