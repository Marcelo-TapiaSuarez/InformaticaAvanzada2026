// TODO: Crear esta excepción.
// Debe ser una excepción Checked (verificada) y permitir pasar un mensaje de error.
public class EquipoNoDisponibleException extends Exception
{
    public EquipoNoDisponibleException(String mensaje)
    {
        super(mensaje);
    }
}