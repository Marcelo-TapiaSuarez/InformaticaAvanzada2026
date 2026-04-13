
public class Docente 
{
    private int dni;
    private String nombre;

    public Docente(int dni, String nombre)
    {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni()
    {
        return dni;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setDni(int dni)
    {
        this.dni = dni;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
