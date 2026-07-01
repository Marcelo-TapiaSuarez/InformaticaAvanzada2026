public class Arma extends Artefacto 
{
    
    // TODO: Implementar constructor que llame a super()
    // El prefijo para las Armas debe ser siempre "ARMA"
    public Arma(String nombre, Integer requisitoNivel) 
    {
        super("ARMA",nombre, requisitoNivel);
    }
}