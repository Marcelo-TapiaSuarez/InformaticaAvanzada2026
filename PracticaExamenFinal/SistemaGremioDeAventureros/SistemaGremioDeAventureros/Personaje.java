import java.util.List;
import java.util.ArrayList;

public class Personaje {
    private BovedaGlobal boveda;
    private Integer nivel;
    private List<Artefacto> mochila;

    public Personaje(Integer nivelInicial) 
    {
        // TODO: 
        // 1. Inicializar la mochila como un ArrayList vacío.
        // 2. Conectar con el Singleton de la BovedaGlobal.
        // 3. Si nivelInicial es nulo o menor a 1, setear nivel en 1. Sino, usar nivelInicial.
        mochila = new ArrayList<>();
        boveda = BovedaGlobal.getInstance();
        
        if(nivelInicial == null || nivelInicial < 1)
        {
            this.nivel = 1;
            return;
        }
        
        this.nivel = nivelInicial;
    }

    /**
     * El personaje intenta reclamar un artefacto de la bóveda.
     * * Reglas:
     * 1. Validar que 'art' no sea nulo (Lanza IllegalArgumentException).
     * 2. Validar que el 'nivel' del personaje sea MAYOR O IGUAL al requisito del artefacto.
     * Si no lo es, LANZAR NivelInsuficienteException.
     * 3. Intentar extraer el artefacto de la bóveda (usando extraerArtefacto).
     * 4. Si la bóveda devolvió null (significa que alguien más se lo llevó o no existía), 
     * lanzar IllegalArgumentException("El artefacto ya no está en la bóveda").
     * 5. Si todo salió bien, agregar el artefacto a la mochila.
     */
    public void reclamarArtefacto(Artefacto art) throws IllegalArgumentException, NivelInsuficienteException// TODO: ¡Ajustar firma!
    {
        // TODO: Implementar lógica de transacción dejando fluir las excepciones (SIN try-catch).
        if(art == null)
        {
            throw new IllegalArgumentException("Artefacto nulo");
        }
        
        if(art.getRequisitoNivel() > getNivel())
        {
            throw new NivelInsuficienteException("Nivel insuficiente");
        }
        
        Artefacto removido = boveda.extraerArtefacto(art.getIdArtefacto());
        
        if(removido == null)
        {
            throw new IllegalArgumentException("El artefacto ya no está en la bóveda");
        }
        
        mochila.add(removido);
    }

    public Integer getNivel() { return nivel; }
    public List<Artefacto> getMochila() { return mochila; }
}