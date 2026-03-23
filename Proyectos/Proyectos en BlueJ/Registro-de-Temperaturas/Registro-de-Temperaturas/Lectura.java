class Lectura
{
    private String ciudad;
    private Double temperatura;

    public Lectura(String ciudad, Double temperatura)
    {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public Double getTemperatura()
    {
        return temperatura;
    }
}