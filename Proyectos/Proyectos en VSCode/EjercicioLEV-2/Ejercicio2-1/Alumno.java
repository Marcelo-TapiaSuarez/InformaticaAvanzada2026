

public class Alumno 
{
    private String matricula;
    private String nombre;
    private int edad;


    public Alumno(String matricula, String nombre, int edad)
    {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }
}
