import java.util.ArrayList;

/**
 * Esta clase modela un personaje de un juego de rol.
 */
public class Personaje 
{
    private final Integer MAX_VIDA;
    private final Integer PESO_MAXIMO_BOLSA;
    // nombre -> el nombre del personaje
    private String nombre;
    // vida -> valor actual de vida
    private Integer vida;
    // caldero -> el caldero para preparar pocimas
    private Caldero caldero;
    // objeto -> el elemento que tiene en sus manos
    //           Puede tener las manos vacias (null)
    private Elemento objeto;
    // bolsa -> la Bolsa de elementos
    private Bolsa bolsa;

    /**
     * Crea un personaje con el nombre dado y configura los
     * campos de la superclase: vida, MAX_VIDA y PESO_MAXIMO_BOLSA.
     * 
     * El personaje se inicializa sin bolsa, sin caldero y
     * con las manos vacias.
     * 
     * @param nombre El nombre del personje.
     * @param vida El valor inicial y maximo de vida del personaje.
     * @param peso El peso maximo que puede transportar el personaje.
     */
    public Personaje (String nombre, Integer vida, Integer peso) 
    {

        this.nombre = nombre;
        this.vida = vida;
        MAX_VIDA = vida;
        PESO_MAXIMO_BOLSA = peso;
        objeto = null;
        caldero = null;
        bolsa = null;
    }

    /**
     * Establece la nueva bolsa para el personaje.
     * 
     * Solo se puede asignar bolsas cuyo peso maximo de carga
     * no supere el maximo soportado por el personaje.  Si el
     * personaje ya tiene una bolsa asociada, la nueva bolsa
     * debe tener mayor capacidad que la actual.  Si no se
     * cumple algunos de los requisito se debe imprimir:
     *         "Bolsa inapropiada"
     * 
     * En caso de reemplazar la bolsa actual, deben pasarse
     * todos los objetos a la nueva bolsa.
     * 
     * @param bolsa La nueva bolsa del personaje.
     */
    public void setBolsa(Bolsa bolsa) 
    {
        if(bolsa == null || bolsa.getPesoMaximo() > PESO_MAXIMO_BOLSA)
        {
            System.out.println("Bolsa inapropiada");
            return;
        }
        
        if(getBolsa() == null)
        {
            this.bolsa = bolsa;
        }
        else if(bolsa.getPesoMaximo() > getBolsa().getPesoMaximo())
        {
            for(Elemento e : getBolsa().getElementosEnLaBolsa())
            {
                bolsa.addElemento(e);
                getBolsa().delElemento(e.getNombre());
            }
            this.bolsa = bolsa;
        }
        else System.out.println("Bolsa inapropiada");
    }

    /**
     * Devuelve la bolsa del personaje.
     * 
     * @return La bolsa del personaje.
     */
    public Bolsa getBolsa() {
        return bolsa;
    }

    /**
     * Guarda el elemento que tiene en sus manos en la bolsa, siempre
     * y cuando haya lugar suficiente.  Las manos quedan vacias (null).
     * 
     * Si las manos estan vacias (null), mostrar "No hay elemento
     * para agregar a la bolsa"
     */
    public void guardarElemento() 
    {
        if(getElemento() == null)
        {
            System.out.println("No hay elemento para agregar a la bolsa");
            return;
        }

        if(getBolsa() == null) return;

        int cantidad = getBolsa().getElementosEnLaBolsa().size();

        getBolsa().addElemento(getElemento());

        if(getBolsa().getPesoActual() > cantidad) objeto = null;
    }

    /**
     * Toma un elemento de la bolsa (delElemento) y lo pone
     * en las manos del personaje.
     * 
     * Si no existe el elemento se debe imprimir
     *       "No se cuenta con el <nombre>"
     * donde <nombre> es el nombre del elemento buscado.
     * 
     * @param nombre El elemento a tomar de la bolsa.
     */
    public void tomarElemento (String nombre) 
    {
        if(nombre == null) return;

        if(getBolsa() != null)
        {
            Elemento sacado = getBolsa().delElemento(nombre);

            if(sacado == null)
            {
                System.out.println("No se cuenta con el " + nombre);
            }
            else objeto = sacado;
        }

    }

    /**
     * Asigna el caldero al personaje.
     * 
     * @param caldero El caldero para el personaje.
     */
    public void setCaldero(Caldero caldero) {
        this.caldero = caldero;
    }
    
    /**
     * Devuelve el caldero que posee el personaje.
     * 
     * @return El caldero que posee el personaje.
     */
    public Caldero getCaldero() {
        return caldero;
    }

    /**
     * Prepara la pocima de la receta en el caldero.
     * 
     * Se debe agregar la receta al caldero (setReceta)
     * y luego, tomar de la bolsa los ingredientes.
     * 
     * En caso de no contar con todos los ingredientes se
     * debe imprimir:
     *       "Faltan <n> ingredientes para <receta>"
     * donde <n> es la cantidad de ingredientes faltantes y
     * <receta> es el nombre de la receta.
     * 
     * @param receta
     */
    public void prepararReceta (Receta receta) 
    {
        if(receta == null || getCaldero() == null) return;

        getCaldero().setReceta(receta);

        if(getBolsa() != null)
        {
            for(String ingrediente : receta.getIngredientes())
            {
                Elemento sacado = getBolsa().delElemento(ingrediente);
                
                if(sacado != null)
                {
                    getCaldero().addIngrediente(sacado);
                }
            }
        }
        

        if(!getCaldero().getIngredientesFaltantes().isEmpty())
        {
            System.out.println("Faltan " + getCaldero().getIngredientesFaltantes().size() + " ingredientes para " + receta.getNombre());
            return;
        }
        else getCaldero().prepararPocima();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void resetVida(Integer vida) {
        this.vida = MAX_VIDA;
    }

    public Elemento getElemento () {
        return objeto;
    }

    public void setElemento (Elemento objeto) {
        this.objeto = objeto;
    }

}
