import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class PanolCentral 
{
    // TODO: Implementar la variable para el Singleton
    private static PanolCentral singleton = null;
    
    // La clave es el codigoInventario
    private Map<String, Instrumento> inventario;

    private PanolCentral() {
        this.inventario = new HashMap<>();
    }

    // TODO: Implementar el método getInstance() del patrón Singleton
    public static PanolCentral getInstance()
    {
        if(singleton == null)
        {
            return singleton = new PanolCentral();
        }
        return singleton;
    }

    /**
     * Agrega un instrumento al catálogo.
     * @throws IllegalArgumentException si el instrumento o su código son null
     */
    public void registrarInstrumento(Instrumento inst) throws IllegalArgumentException 
    {
        // TODO: Implementar método
        if(inst == null || inst.getCodigoInventario() == null)
        {
            throw new IllegalArgumentException("Instrumento nulo o código nulo");
        }
        
        inventario.put(inst.getCodigoInventario(), inst);
        
    }

    /**
     * Verifica si el código existe en el inventario.
     * @throws IllegalArgumentException si el código es null o vacío
     */
    public Boolean consultarDisponibilidad(String codigo) throws IllegalArgumentException 
    {
        // TODO: Implementar método
        if(codigo == null || codigo.equals(""))
        {
            throw new IllegalArgumentException("Código nulo o vacío");
        }
        
        return inventario.containsKey(codigo); // Cambiar
    }

    /**
     * Remueve y retorna un instrumento del catálogo.
     * @return El instrumento removido o null si no existía.
     */
    public Instrumento retirarInstrumento(String codigo) {
        if(codigo == null) return null;
        return inventario.remove(codigo);
    }

    /**
     * Genera una lista de los instrumentos en el pañol ordenados alfabéticamente por modelo.
     * Formato esperado: "Cód: <codigo> | Mod: <modelo> | Seguro: $<valorReposicion>"
     * Ejemplo: "Cód: MULT-1 | Mod: Fluke 87V | Seguro: $500.0"
     */
    public List<String> getListadoPorModelo() 
    {
        // TODO: Implementar método
        Map<String, Instrumento> treeMap = new TreeMap<>();
        
        for(String n : inventario.keySet())
        {
            treeMap.put(n+inventario.get(n).getCodigoInventario(),inventario.get(n));
        }
        
        List<String> lista = new ArrayList<>();
        
        for(Instrumento i : treeMap.values())
        {
            String formato = "Cód: " + i.getCodigoInventario() + " | Mod: " + i.getModelo() + " | Seguro: $" + i.getValorReposicion();
            lista.add(formato);
        }
        
        return lista; // Cambiar
    }
}