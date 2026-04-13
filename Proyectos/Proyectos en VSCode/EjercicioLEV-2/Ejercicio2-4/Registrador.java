//import java.util.HashSet;
import java.util.ArrayList;

public class Registrador 
{
    private String designacion;
    private ArrayList<Registro> registros; //Definir coleccion apropiada
    
    //Constructor
    public Registrador (String designacion)
    {
        // Completar metodo
        this.designacion = designacion;
        registros = new ArrayList<>();
    }
    
    //Metodos
    //getters
    public String getDesignacion (){
        return designacion;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los registros 
   * guardados. 
   * @return La coleccion con el listado de registros.
   */
    public ArrayList<Registro> getRegistros()
    { 
        //Definir coleccion apropiada
        // Completar metodo
        return registros;
    }
    
   /**
   * Este metodo devuelve el objeto del tipo Registro en la posicion
   * i de la coleccion.
   * @param  i  El indice solicitado
   * @return El registro con indice i.
   */
    public Registro getRegistro (int i)
    {
        return registros.get(i);  // No olvide modificar esta linea
    }
    //setters
    public void setDesignacion (String designacion)
    {
        // Completar metodo
        this.designacion = designacion;
    }

   /**
   * Este metodo permite agregar un registro a la coleccion elegida   
   * @param registro Registro que se desea agregar a la coleccion.
   */
    public void agregarRegistro (Registro registro)
    {
        // Completar metodo
        registros.add(registro);
    }
}