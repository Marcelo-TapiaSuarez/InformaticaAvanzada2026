import java.util.HashSet;
//import java.util.ArrayList;
//import java.util.Iterator;

public class Gondola 
{
    private String pasillo;
    private HashSet<Producto> productos;  // Definir clase de coleccion a utilizar
    
    //Constructor
    public Gondola (String pasillo)
    {
        // Completar este metodo inicializando todos los atributos 
        this.pasillo = pasillo;
        productos = new HashSet<>();
    }
    
    //Metodos
    //getters
    public String getPasillo ()
    {
        return pasillo;
    }

   /**
   * Este metodo devuelve la coleccion que contiene los productos 
   * que se encuentran en la gondola. 
   * @return La coleccion con el listado de productos.
   */
    public HashSet<Producto> getProductos()
    {   
        // Definir clase de coleccion 
        // Completar este metodo
        return productos;
    }
    
    //setters
    public void setPasillo (String pasillo)
    {
        // Completar este metodo
        this.pasillo = pasillo;
    }

   /**
   * Este metodo permite agregar un producto a la coleccion elegida   
   * @param producto El producto que se desea agregar a la coleccion.
   */
    public void agregarProducto (Producto producto)
    {
        // Completar este metodo
        productos.add(producto);
    }
    
    /**
   * Este metodo devuelve la cantidad de productos pertenecientes en la
   * gondola.
   * @return Cantidad de productos en la coleccion.
   */
    public int cantidadProductos ()
    {
        // Completar este metodo
        return productos.size();
    }
}