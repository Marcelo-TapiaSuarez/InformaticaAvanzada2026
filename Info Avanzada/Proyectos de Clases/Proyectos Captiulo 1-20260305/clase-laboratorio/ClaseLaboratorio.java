import java.util.*;

/**
 * La ClaseLaboratorio es una clase que representa la planilla de inscriptos para
 * una clase de laboratorio. Almacen la hora de clases, aula y lista de estudiantes,
 * como también el nombre del profesor.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */
public class ClaseLaboratorio
{
    private String instructor;
    private String aula;
    private String diaYhora;
    private ArrayList<Estudiante> estudiantes;
    private Integer capacidad;
    
    /**
     * Crea una ClaseLaboratorio con cupo de estudiantes. El resto de los detalles
     * se configuran con los valores por defecto.
     */
    public ClaseLaboratorio(int cantidadMaximaEstudiantes)
    {
        instructor = "no-asignado";
        aula = "no-asignado";
        diaYhora = "no-asignado";
        estudiantes = new ArrayList<Estudiante>();
        capacidad = cantidadMaximaEstudiantes;
    }

    /**
     * Agrega un estudiante a ClaseLaboratorio.
     */
    public void anotarEstudiante(Estudiante newEstudiante)
    {
        if(estudiantes.size() == capacidad) {
            System.out.println("Clase completa, no se puede inscribir.");
        }
        else {
            estudiantes.add(newEstudiante);
        }
    }
    
    /**
     * Devuelve el número de estudiantes inscriptos en esta ClaseLaboratorio.
     */
    public Integer numeroDeEstudiantes()
    {
        return estudiantes.size();
    }
    
    /**
     * Setea el número de aula de esta ClaseLaboratorio.
     */
    public void setAula(String numeroAula)
    {
        aula = numeroAula;
    }
    
    /**
     * Setea la hora para esta ClaseLaboratorio. El parámetro debe
     * definir el día y la hora del día, por ejemplo "Viernes, 15:00"..
     */
    public void setHora(String stringDiaHora)
    {
        diaYhora = stringDiaHora;
    }
    
    /**
     * Setea el nombre del instructor de esta ClaseLaboratorio.
     */
    public void setInstructor(String nombreInstructor)
    {
        instructor = nombreInstructor;
    }
    
    /**
     * Imprime en la terminal de salida los detalles y la lista de
     * inscriptos de esta ClaseLaboratorio.
     */
    public void printLista()
    {
        System.out.println("Clase Laboratorio " + diaYhora);
        System.out.println("Instructor: " + instructor + "   Aula: " + aula);
        System.out.println("Inscriptos:");
        for(Estudiante estudiante : estudiantes) {
            estudiante.print();
        }
        System.out.println("Numero de estudiantes: " + numeroDeEstudiantes());
    }
}
