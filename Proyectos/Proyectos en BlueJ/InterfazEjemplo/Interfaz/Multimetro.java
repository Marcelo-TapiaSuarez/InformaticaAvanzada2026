public class Multimetro extends Instrumento implements Exportable 
{
    public Multimetro(String nombre, String marca)
    {
        super(nombre, marca);
    }

    @Override
    public void realizarMedicion()
    {
        System.out.println("Medicion de tension en paralelo: 5V");
    }

    @Override
    public void exportarDatos()
    {
        System.out.println("Exportando datos via Bluetooth...");
    }
    
}
