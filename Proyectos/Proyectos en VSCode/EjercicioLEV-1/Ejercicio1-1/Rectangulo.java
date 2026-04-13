

public class Rectangulo 
{
    int largo;
    int alto;

    public Rectangulo(){}

    public Rectangulo(int largo, int alto)
    {
        setLargo(largo);
        setAlto(alto);
    }

    public void setLargo(int largo)
    {
        if(largo >= 0)
        {
            this.largo = largo;
            return;
        }
        //this.largo = 0;
    }

    public void setAlto(int alto)
    {
        if(alto >= 0)
        {
            this.alto = alto;
            return;
        }
        //this.alto = 0;
    }

    public int getLargo()
    {
        return largo;
    }

    public int getAlto()
    {
        return alto;
    }

    public int getArea()
    {
        return largo*alto;
    }

    public int getPerimetro()
    {
        return (alto + largo)*2;
    }
}
