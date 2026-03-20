/**
 * Tickeadora modela una máquina que entrega tickets de tarifa única.
 * 
 * El valor del ticket se especifica en el constructor.
 * Esta es una máquina simple en el sentido que confía en que
 * los usuarioas van a ingresar la cantidad suficiente de dinero
 * antes de imprimir un ticket. También asume que los usuarios
 * ingresan valor correcto.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */
public class Tickeadora
{
    // El precio de un ticket en esta máquina.
    private Integer precio;
    // La cantidad ingresada al momento por un cliente.
    private Integer balance;
    // El monto total del dinero recaudado por esta máquina.
    private Integer total;

    /**
     * Crea una nueva máquina que entrega tickets por el precio indicado.
     * Note que el precio debe ser mayor que cero y que no existe control
     * para garatizar que se cumpla.
     */
    public Tickeadora(Integer costo)
    {
        precio = control(costo);
        balance = 0;
        total = 0;
    }

    private Integer control(Integer c){
        if(c < 0) return 0;
        return c;
    }

    /**
     * Devuelve el precio de un ticket.
     */
    public Integer getPrecio()
    {
        return precio;
    }

    /**
     * Devuelve la cantidad de dinero ingresada al momento por un cliente
     * para el próximo ticket.
     */
    public Integer getBalance()
    {
        return balance;
    }

    /**
     * Recibe una suma de dinero del cliente.
     */
    public void insertarDinero(Integer cantidad)
    {
        balance = balance + control(cantidad);
    }

    /**
     * Imprime un ticket.
     * Actualiza el total acumulado y vuevle a cero al balance.
     */
    public void printTicket()
    {
        // Actualiza el total acumulado con el balance.
        
        // Reinicia el balance.
        if(limite(balance))
        {
            System.out.println("##################");
            System.out.println("# La linea BlueJ");
            System.out.println("# Ticket");
            System.out.println("#Saldo Insuficiente");
            System.out.println("##################");
        }
        else
        {
            // Simula la impresión de un ticket.
            System.out.println("##################");
            System.out.println("# La linea BlueJ");
            System.out.println("# Ticket");
            System.out.println("# " + precio + " pesos.");
            System.out.println("##################");
            System.out.println();
            total = total + precio;
            balance = balance - precio;
        }
        
    }

    private Boolean limite(Integer bal)
    {
        return bal<=-2000;
    }
}
