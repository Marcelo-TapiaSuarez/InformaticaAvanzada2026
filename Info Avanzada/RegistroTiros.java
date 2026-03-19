import java.util.ArrayList;

public class RegistroTiros
{
    private ArrayList<Proyectil> lista;

    public RegistroTiros()
    {
        lista = new ArrayList<>();
    }

    public void agregarProyectil(Proyectil nuevoTiro)
    {
        lista.add(nuevoTiro);
    }

    public Integer cantidadTiros()
    {
        return lista.size();
    }

    public void mostrarHistorial()
    {
        for(Proyectil tiro : lista)
        {
            tiro.imprimirDetalles();
        }
    }

    public Proyectil tiroMasTardado()
    {
        if(!lista.isEmpty())
        {
            Proyectil temp = lista.getFirst();
            for(Proyectil tiro : lista)
            {
                if(tiro.calcularTiempoVuelo() > temp.calcularTiempoVuelo())
                {
                    temp = tiro;
                }
            }
            return temp;
        }
        return null;
    }

    public Proyectil tiroMasLejano()
    {
        if(!lista.isEmpty())
        {
            Proyectil temp = lista.getFirst();
            for(Proyectil tiro : lista)
            {
                if(tiro.calcularDistanciaMaxima() > temp.calcularDistanciaMaxima())
                {
                    temp = tiro;
                }
            }
            return temp;
        }
        return null;
    }
}