public class GestionPrestamos 
{
    private PanolCentral panol;
    private Double fondoGarantia;

    public GestionPrestamos() 
    {
        // TODO: Inicializar la conexión con el Singleton del Pañol y setear el fondo en 0.0
        panol = PanolCentral.getInstance();
        fondoGarantia = 0.0;
    }

    /**
     * Gestiona el retiro de un equipo.
     * Reglas:
     * 1. Validar que inst y cantidadHoras no sean null, y que horas > 0 (Lanza IllegalArgumentException)
     * 2. Validar que el equipo exista en el pañol (Lanza EquipoNoDisponibleException)
     * 3. Si todo está ok, suma al fondo un 5% del valor de reposición por cada hora.
     * 4. Retira el equipo del pañol.
     */
    public void retirarParaPractica(Instrumento inst, Integer cantidadHoras) // TODO: Ajustar firma si es necesario
    {
        // TODO: Implementar lógica de transacción (Atención al orden y a las excepciones)
        try
        {
            comprobacionCampos(inst, cantidadHoras);
            comprobacionDisponibilidad(inst);
            
            fondoGarantia += (inst.getValorReposicion()*5.0/100.0) * cantidadHoras;
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch(EquipoNoDisponibleException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void comprobacionCampos(Instrumento inst, Integer cantidadHoras) throws IllegalArgumentException
    {
        if(inst == null)
        {
            throw new IllegalArgumentException("Instrumento nulo");
        }
        
        if(cantidadHoras == null || cantidadHoras <= 0)
        {
            throw new IllegalArgumentException("Cantidad de horas no válido");
        }
    }
    
    private void comprobacionDisponibilidad(Instrumento inst) throws EquipoNoDisponibleException
    {
        if(!panol.consultarDisponibilidad(inst.getCodigoInventario()))
        {
            throw new EquipoNoDisponibleException("Equipo no disponible");
        }
    }
    
    public Double getFondoGarantia() { 
        return fondoGarantia; 
    }
}