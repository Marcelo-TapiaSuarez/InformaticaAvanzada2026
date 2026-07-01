// TODO: Crear esta excepción.
// Debe ser una excepción Checked (verificada) y permitir pasar un mensaje de error.
public class NivelInsuficienteException extends Exception
{
    public NivelInsuficienteException(String mensaje)
    {
        super(mensaje);
    }
}