//import java.util.HashSet;
import java.util.ArrayList;

public class Aula 
{
    private String materia;
    // Utilizar la coleccion que considere apropiada
    // Defina una coleccion para el listadoDeAlumnos
    //<TBD> listadoDeAlumnos;
    private ArrayList<Alumno> lista;
    
    //Constructor
    public Aula (String materia)
    {
        this.materia = materia;
        lista = new ArrayList<>();
        //complete el constuctor
    }
    
    //Metodos
    //getters
    public String getMateria ()
    {
        return materia;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los alumnos 
   * pertenecientes al curso. 
   * @return La coleccion con el listado de alumnos.
   */
    public ArrayList<Alumno> getListado()
    {
        //Implemente este metodo
        return lista;   // No olvide modificar esta linea
    }
    
   /**
   * Este metodo devuelve el objeto del tipo Alumno en la posicion
   * i de la coleccion.
   * @param  i  El indice solicitado
   * @return El alumno con indice i.
   */
    public Alumno getAlumno(int i)
    {
        //Implemente este metodo
        return lista.get(i);   // No olvide modificar esta linea
    }

    //setters
    public void setMateria (String materia)
    {
        this.materia = materia;
    }

   /**
   * Este metodo permite agregar un alumno a la coleccion elegida   
   * @param alumno Alumno que se desea agregar a la coleccion.
   */
    public void agregarAlumno (Alumno alumno)
    {
        lista.add(alumno);
    }
}
