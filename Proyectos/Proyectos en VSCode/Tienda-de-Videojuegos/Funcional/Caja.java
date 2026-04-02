package Funcional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Caja 
{
    private ArrayList<String> chart;
    private TreeSet<String> ticket;
    
    public Caja()
    {
        chart = new ArrayList<>();
        ticket = new TreeSet<>();
    }

    /**
     * Crea un nuevo carrito de compras.
     * @param game Nombre del videojuego.
     */

    public void setChart(String game)
    {
        chart.add(game);
    }

    /**
     * Obtiene el ticket sin repetidos, listo para imprimir.
    */
    public void finalTicket()
    {
        for(String c : chart)
        {
            ticket.add(c);
        }
    }

    /**
     * Obtiene el precio total a pagar del carrito que generó el usuario.
     * 
     * @param c Recibe el catálogo que posee la tienda en ese momento.
     * @return Devuelve el total a pagar.
     */

    public Double totalPrice(Catalogue c)
    {
        return chart.stream().map(game -> c.getPrice(game)-getDiscount(c, game)).reduce(0.0, (a,b)->a+b);
    }

    /**
     * Si el cliente agrega a su carrito, juegos que valen más de $60.0, se le aplica un descuento.
     * 
     * @param c Recibe el catálogo de la tienda en ese momento.
     * @return Devuelve True si hay algún juego de más de $60.0. Caso contrario, devuelve False.
     */

    private Boolean vipDiscount(Catalogue c, String game)
    {
        return chart.contains(game) && c.getPrice(game) > 60.0 ? true : false;
    }

    /**
     * Aplica el decuento VIP del 10%.
     * @param c Catalogo de videojuegos.
     * @param game Nombre del videojuego.
     * @return Devuelve el precio del videojuego con el descuento aplicado.
     */

    private Double getDiscount(Catalogue c, String game)
    {
        return vipDiscount(c, game) ? c.getPrice(game)/10 : 0.0;
    }

    /**
     * Imprime el ticket final para el cliente.
     * @param cat Recibe el catalogo de videojuegos.
     */

    public void printTicket(Catalogue cat)
    {
        System.out.println("/***************** Ticket Final *******************/");
        for(String t : ticket)
        {
            System.out.println("Videojuego: " + t + " Cantidad: " + Collections.frequency(chart, t) + " Precio: $" + cat.getPrice(t));
            if(vipDiscount(cat, t))
            {
                System.out.println("Descuento: -$" + getDiscount(cat, t));
            }
        }
        System.out.println("/**************************************************/");
        System.out.println("Precio Final: $" + totalPrice(cat));
    }
}
