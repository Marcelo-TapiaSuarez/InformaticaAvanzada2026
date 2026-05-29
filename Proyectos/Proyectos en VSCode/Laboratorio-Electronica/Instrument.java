public abstract class Instrument 
{
    private String name;
    private String marca;

    public Instrument(String name, String marca)
    {
        this.name = name;
        this.marca = marca;
    }

    public String getMarca()
    {
        return marca;
    } 

    public void encender()
    {
        System.out.println("Aparato encendido");
    }

    public abstract void realizarMedicion();
    
}
