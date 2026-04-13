
public class Producto 
{
    private int codigoBarra;
    private String descripcion;
    private double precio;

    public Producto(int codigoBarra, String descripcion, double precio)
    {
        this.codigoBarra = codigoBarra;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigoBarra()
    {
        return codigoBarra;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setCodigoBarra(int codigoBarra)
    {
        this.codigoBarra = codigoBarra;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }    
}
