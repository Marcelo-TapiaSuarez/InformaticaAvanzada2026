public abstract class Instrumento 
{
    private String name;
    private String marca;

    public Instrumento(String name, String marca)
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