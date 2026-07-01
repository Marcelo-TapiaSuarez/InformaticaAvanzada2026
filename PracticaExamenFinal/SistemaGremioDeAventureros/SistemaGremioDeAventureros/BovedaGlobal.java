import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BovedaGlobal 
{
    
    // TODO: Implementar Singleton
    private static BovedaGlobal singleton = null;    
    // La clave es el idArtefacto
    private Map<String, Artefacto> tesoros;

    private BovedaGlobal() {
        this.tesoros = new HashMap<>();
    }

    // TODO: Implementar getInstance()
    public static BovedaGlobal getInstance()
    {
        if(singleton == null)
        {
            return singleton = new BovedaGlobal();
        }
        
        return singleton;
    }
    
    /**
     * Guarda un artefacto en la bóveda.
     * @throws IllegalArgumentException si el artefacto o su id son nulos.
     */
    public void registrarArtefacto(Artefacto art) throws IllegalArgumentException 
    {
        // TODO: Implementar método
        if(art == null || art.getIdArtefacto() == null)
        {
            throw new IllegalArgumentException("Artefacto invalido");
        }
        
        tesoros.put(art.getIdArtefacto(), art);
    }

    /**
     * Remueve y retorna un artefacto de la bóveda usando su ID.
     * @return El artefacto removido, o null si el ID no existía en el mapa.
     */
    public Artefacto extraerArtefacto(String id) 
    {
        // TODO: Implementar método
        if(id == null || id.isEmpty() || !tesoros.containsKey(id))
        {
            return null;
        }
        return tesoros.remove(id); // Cambiar
    }

    /**
     * Genera un listado de los tesoros en la bóveda, ordenados por Requisito de Nivel 
     * de MAYOR a MENOR (los más poderosos primero).
     * Formato esperado de cada String: "[<idArtefacto>] <nombre> (Requiere Nivel <requisitoNivel>)"
     */
    public List<String> getListadoPorPoder() 
    {
        // TODO: Implementar método. 
        // TIP: Para ordenar números en orden descendente con lambda: (a, b) -> Integer.compare(b.getRequisitoNivel(), a.getRequisitoNivel())
        
        return  tesoros.values().stream()
                .sorted((art1, art2) -> Integer.compare(art2.getRequisitoNivel(), art1.getRequisitoNivel()))
                .map(a -> "[" + a.getIdArtefacto() + "] " + a.getNombre() + "(Requiere Nivel " + a.getRequisitoNivel() + ")")
                .collect(Collectors.toCollection(() -> new ArrayList<>())); // Cambiar
    }
}