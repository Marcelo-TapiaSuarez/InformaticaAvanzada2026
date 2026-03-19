
/**
 * La clase Estudiante que representa a los estudiantes de un sistema de administración
 * de clases. Retiene los datos relevantes del estudiante para este contexto.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */
public class Estudiante
{
    // Nombre completo del estudiante
    private String nombre;
    // Número de ID del estudiante
    private String id;
    // la cantidad de créditos por los cursos tomados
    private Integer creditos;

    /**
     * Crea un nuevo estudiante con el nombre y número de ID dados.
     */
    public Estudiante(String nombreCompleto, String IDestudiante)
    {
        nombre = nombreCompleto;
        id = IDestudiante;
        creditos = 0;
    }

    /**
     * Devuelve el nombre completo de este estudiante.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Setea un nombre nuevo para este estudiante.
     */
    public void setNombre(String newNombre)
    {
        nombre = newNombre;
    }

    /**
     * Devuelve el número de ID de este estudiante.
     */
    public String getIDestudiante()
    {
        return id;
    }

    /**
     * Suma créditos a los acumulados por este estudiante.
     */
    public void addCreditos(Integer puntosAdicionales)
    {
        creditos += puntosAdicionales;
    }

    /**
     * Devuelve el número de créditos que tiene acumulado este estudiante.
     */
    public Integer getCreditos()
    {
        return creditos;
    }

    /**
     * Devuelve el nombre de usuario para login de este estudiante. El usuario
     * es una combinación de los primeros cuatro caracteres de su nombre y los
     * primeros tres caracteres de su número de ID.
     */
    public String getNombreLogin()
    {
        return nombre.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Imprime el nombre, número de ID y créditos en la terminal de salida.
     */
    public void print()
    {
        System.out.println(nombre + ", ID estudiante: " + id + ", creditos: " + creditos);
    }
}
