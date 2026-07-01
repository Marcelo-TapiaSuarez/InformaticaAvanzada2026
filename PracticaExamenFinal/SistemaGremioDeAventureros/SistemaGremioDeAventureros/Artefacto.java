public abstract class Artefacto 
{
    private static Integer contador = 0;
    private final String idArtefacto;
    private String nombre;
    private Integer requisitoNivel;

    /**
     * Constructor principal.
     * Reglas de validación defensiva:
     * - Si nombre es null o vacío, asignar "Artefacto Desconocido".
     * - Si requisitoNivel es null o menor a 1, asignar 1.
     * - El idArtefacto debe generarse usando el método privado.
     */
    public Artefacto(final String prefijo, String nombre, Integer requisitoNivel) 
    {
        // TODO: Implementar constructor (¡Cuidado con los return anticipados!)
        idArtefacto = generarId(prefijo);
        
        if(nombre == null || nombre.isEmpty())
        {
            this.nombre = "Artefacto Desconocido";
        }
        else
        {
            this.nombre = nombre;
        }
        
        if(requisitoNivel == null || requisitoNivel < 1)
        {
            this.requisitoNivel = 1;
        }
        else
        {
            this.requisitoNivel = requisitoNivel;
        }
    }

    /**
     * Genera el ID uniendo el prefijo y el contador.
     * Ejemplo: prefijo "ARMA" -> "ARMA_1"
     * @throws IllegalArgumentException si el prefijo es null o vacío.
     */
    private String generarId(final String prefijo) throws IllegalArgumentException 
    {
        // TODO: Implementar método
        if(prefijo == null || prefijo.isEmpty())
        {
            throw new IllegalArgumentException("Prefijo nulo o vacío");
        }
        
        contador++;
        
        return prefijo + "_" + contador; // Cambiar este return
    }

    // Getters
    public String getIdArtefacto() { return idArtefacto; }
    public String getNombre() { return nombre; }
    public Integer getRequisitoNivel() { return requisitoNivel; }

    @Override
    public String toString() {
        return "Artefacto [" + idArtefacto + " | " + nombre + " | Lvl: " + requisitoNivel + "]";
    }
}