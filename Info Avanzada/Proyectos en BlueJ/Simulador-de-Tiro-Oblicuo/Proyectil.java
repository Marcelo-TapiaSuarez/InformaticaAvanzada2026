public class Proyectil
{
    private String nombre;
    private Double velocidadInicial;
    private Double angulo;

    public Proyectil(String nombre, Double velocidadInicial, Double angulo)
    {
        this.nombre = nombre;
        
        if(!(velocidadInicial > 0.0 && angulo >= 0.0 && angulo <= 90.0))
        {
            this.velocidadInicial = 0.0;
            this.angulo = 0.0;
            return;
        }
        this.velocidadInicial = velocidadInicial;
        this.angulo = angulo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public Double getVelocidadInicial()
    {
        return velocidadInicial;
    }

    public Double getAngulo()
    {
        return angulo;
    }

    public void imprimirDetalles()
    {
        System.out.println("El objeto es: " + nombre);
        System.out.println("Su velocidad inicial es de: " + velocidadInicial + " [m/s]");
        System.out.println("El ángulo de tiro es: " + angulo + "°");
    }

    public Double calcularTiempoVuelo()
    {
        return 2*velocidadInicial*Math.sin(Math.toRadians(angulo))/9.81;
    }

    public Double calcularDistanciaMaxima()
    {
        return Math.pow(velocidadInicial, 2.0)*Math.sin(Math.toRadians(angulo))/9.81;
    }
}