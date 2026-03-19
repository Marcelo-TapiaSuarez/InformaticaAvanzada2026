/**
 * Tickeadora modela una máquina que entrega tickets de tarifa única.
 * 
 * El valor del ticket se especifica en el constructor.
 * Las instancias deberán verificar que los ususarios ingresen
 * valores correctos de dinero, y solo imprimirán un ticket
 * si se ingresó una cantidad suficiente.
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
     */
    public Tickeadora(Integer costo)
    {
        precio = costo;
        balance = 0;
        total = 0;
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
     * Verifica que el valor sea válido.
     */
    public void insertarDinero(Integer cantidad)
    {
        if(cantidad > 0) {
            balance = balance + cantidad;
        }
        else {
            System.out.println("Ingrese una cantidad positiva en lugar de: " +
                               cantidad);
        }
    }

    /**
     * Imprime un ticket solo si se ingresó la cantidad suficiente
     * de dinero y descuenta su valor del balance. Imprime un mensaje
     * de error si no hay suficiente dinero.
     */
    public void printTicket()
    {
        if(balance >= precio) {
            // Simula la impresión de un ticket.
            System.out.println("##################");
            System.out.println("# La linea BlueJ");
            System.out.println("# Ticket");
            System.out.println("# " + precio + " pesos.");
            System.out.println("##################");
            System.out.println();

            // Actualiza el total acumulado por el valor de un ticket.
            total = total + precio;
            // Reduce el balance por el precio de un ticket.
            balance = balance - precio;
        }
        else {
            System.out.println("Debe insertar al menos " +
                               (precio - balance) + " pesos mas.");
                    
        }
    }

    /**
     * Entrega el vuelto al cliente y reinicia el balance.
     */
    public Integer getVuelto()
    {
        Integer vuelto;
        vuelto = balance;
        balance = 0;
        return vuelto;
    }
}
