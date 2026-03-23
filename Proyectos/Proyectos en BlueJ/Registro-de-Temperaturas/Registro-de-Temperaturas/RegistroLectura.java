import java.util.ArrayList;
import java.util.stream.Collectors;


public class RegistroLectura 
{
    private ArrayList<Lectura> historial;
    
    public RegistroLectura()
    {
        historial = new ArrayList<>();
    }

    public void agregarCiudad(Lectura lectura)
    {
        historial.add(lectura);
    }

    public long bajoCero()
    {
        return historial.stream().filter(l1 -> l1.getTemperatura() <= 0.0).count();
    }

    public ArrayList<String> ciudadesCalidas()
    {
        return historial.stream().filter(l1 -> l1.getTemperatura() >= 30.0)
                                 .map(Lectura::getCiudad)
                                 .collect(Collectors.toCollection(ArrayList<String>::new));
    }

    public Double maximaTemp()
    {
        return historial.stream().map(Lectura::getTemperatura)
                                 .reduce((l1, l2) -> l1 > l2 ? l1 : l2).orElse(-1.0);
    }

    public void imprimirBajoCero()
    {
        System.out.println("La cantidad de cuidades con temperaturas bajo cero fue de: " + bajoCero());
    }

    public void imprimirMaximaTemp()
    {
        Double tMax = maximaTemp();
        if(tMax != -1.0)
        {
            System.out.println("La temperatura máxima registrada fue de: " + tMax + " °C");
            return;
        }
        System.out.println("No hay registros de temperatura");
    }

    public void imprimirCiudadesCalidas()
    {
        System.out.println("Las ciudades calidas son: ");
        ciudadesCalidas().stream().forEach(ciudad -> System.out.println(ciudad));
        //una forma más corta es: ciudadesCalidas().forEach(System.out::println);
    }

    /* Método Imperativo 
    public void imprimirHistorial()
    {
        for(Lectura lectura : historial)
        {
            System.out.println("Ciudad: " + lectura.getCiudad());
            System.out.println("Temperatura: " + lectura.getTemperatura());
        }
    }
    */

    public void imprimirHistorial()
    {
        historial.forEach(lectura ->
                                    {
                                        System.out.println("Ciudad: " + lectura.getCiudad());
                                        System.out.println("Temperatura: " + lectura.getTemperatura() + " °C");
                                    } 

                         );
    }
}
