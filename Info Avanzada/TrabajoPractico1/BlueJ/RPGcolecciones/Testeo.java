import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Testeo.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Testeo
{
    private Caldero caldero1;
    private Receta receta1;
    private Elemento elemento1;
    private Elemento elemento2;
    private Elemento elemento3;

    
    
    
    
    

    

    /**
     * Default constructor for test class Testeo
     */
    public Testeo()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        caldero1 = new Caldero("Caldero chico", 5);
        receta1 = new Receta("voladora");
        receta1.addIngrediente("Pluma");
        receta1.addIngrediente("Sangre");
        receta1.addIngrediente("Hueso");
        receta1.cerrarReceta();
        elemento1 = new Elemento("Pluma", 1);
        elemento2 = new Elemento("Hueso", 1);
        elemento3 = new Elemento("Sangre", 1);
        elemento1.getNombre();
        caldero1.setReceta(receta1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}