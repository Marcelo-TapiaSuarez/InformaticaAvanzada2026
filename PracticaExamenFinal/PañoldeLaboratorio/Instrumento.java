public abstract class Instrumento 
{
    private static Integer contador = 0;
    private final String codigoInventario;
    private String modelo;
    private Double valorReposicion;

    /**
     * Constructor principal.
     * Reglas:
     * - Si modelo es null o vacío, asignar "Sin modelo".
     * - Si valorReposicion es null o negativo, asignar 0.0.
     * - El codigoInventario debe generarse usando el método privado.
     */
    public Instrumento(final String prefijo, String modelo, Double valorReposicion) 
    {
        // TODO: Implementar constructor
        this.codigoInventario = generarCodigo(prefijo);
        
        if(modelo == null || modelo.equals(""))
        {
            this.modelo = "Sin modelo";
            
            if(valorReposicion == null || valorReposicion < 0)
            {
                this.valorReposicion = 0.0;
                return;
            }
            
            this.valorReposicion = valorReposicion;
            return;
        }
        
        this.modelo = modelo;
        this.valorReposicion = valorReposicion;
    }

    /**
     * Genera el ID uniendo el prefijo y el contador.
     * Ejemplo: prefijo "MULT" -> "MULT-1", luego "MULT-2", etc.
     * @throws IllegalArgumentException si el prefijo es null o vacío.
     */
    private String generarCodigo(final String prefijo) throws IllegalArgumentException 
    {
        // TODO: Implementar método
        if(prefijo == null || prefijo.equals(""))
        {
            throw new IllegalArgumentException("Prefijo nulo");
        }
        
        contador++;
        
        return prefijo + "-" + contador; // Cambiar este return
    }

    // Getters y Setters
    public String getCodigoInventario() { 
        return codigoInventario; 
    }
    
    public String getModelo() { 
        return modelo; 
    }
    
    public Double getValorReposicion() { 
        return valorReposicion; 
    }
    
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }
    
    public void setValorReposicion(Double valor) { 
        this.valorReposicion = valor; 
    }

    @Override
    public String toString() {
        return "Instrumento [codigo=" + codigoInventario + ", modelo=" + modelo + ", valor=$" + valorReposicion + "]";
    }
}