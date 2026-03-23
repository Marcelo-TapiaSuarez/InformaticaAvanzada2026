import java.util.ArrayList;
import java.util.Iterator;

public class RegistroTiros
{
    private ArrayList<Proyectil> lista;
    private Iterator<Proyectil> it;

    public RegistroTiros()
    {
        lista = new ArrayList<>();
        it = lista.iterator();
    }

    public void agregarProyectil(Proyectil nuevoTiro)
    {
        lista.add(nuevoTiro);
    }

    public Integer cantidadTiros()
    {
        return lista.size();
    }

    /* Método con ForEach
    public void mostrarHistorial()
    {
        for(Proyectil tiro : lista)
        {
            tiro.imprimirDetalles();
        }
    }
    */

    // Método con iterator
    public void mostrarHistorial()
    {
        while(it.hasNext())
        {
            it.next().imprimirDetalles();
        }
    }

    /* Método imperativo
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
    */

    /* Método funcional 1
    public Proyectil tiroMasTardado()
    {
        if(!lista.isEmpty())
        {
            Proyectil masTardado = lista.stream().reduce((p1, p2) -> p1.calcularTiempoVuelo() > p2.calcularTiempoVuelo() ? p1 : p2).get();

            return masTardado;
        }
        return null;
    }
    */

    // Método funcional 2
    public Proyectil tiroMasTardado()
    {
        return lista.stream().reduce((p1, p2) -> p1.calcularTiempoVuelo() > p2.calcularTiempoVuelo() ? p1 : p2).orElse(null);
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