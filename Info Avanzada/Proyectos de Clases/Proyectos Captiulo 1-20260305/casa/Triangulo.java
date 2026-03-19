import java.awt.*;

/**
 * Un triángulo que se puede modificar y que se dibuja a sí mismo en un canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */

public class Triangulo
{
    private Integer alto;
    private Integer ancho;
    private Integer posicionX;
    private Integer posicionY;
    private String  color;
    private Boolean isVisible;

    /**
     * Crea un nuevo triángulo en una posición y color por defecto.
     */
    public Triangulo()
    {
        alto = 60;
        ancho = 70;
        posicionX = 210;
        posicionY = 140;
        color = "green";
        isVisible = false;
    }

    /**
     * Hace visible a este triángulo. Si ya está visible, no hace nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Hace invisible a este triángulo. Si ya está visible, no hace nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Mueve el triángulo unos pocos píxeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mueve el triángulo unos pocos píxeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mueve el triángulo unos pocos píxeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mueve el triángulo unos pocos píxeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mueve el triángulo horizontalmente 'distancia' píxeles.
     */
    public void moverHorizontal(Integer distancia)
    {
        erase();
        posicionX += distancia;
        draw();
    }

    /**
     * Mueve el triángulo verticalmente 'distancia' píxeles.
     */
    public void moverVertical(Integer distancia)
    {
        erase();
        posicionY += distancia;
        draw();
    }

    /**
     * Mueve lentamente el triángulo horizontalmente 'distancia' píxeles.
     */
    public void moverLentoHorizontal(Integer distancia)
    {
        Integer delta;

        if(distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for(Integer i = 0; i < distancia; i++)
        {
            posicionX += delta;
            draw();
        }
    }

    /**
     * Mueve lentamente el triángulo verticalmente 'distancia' píxeles.
     */
    public void moverLentoVertical(Integer distancia)
    {
        Integer delta;

        if(distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for(Integer i = 0; i < distancia; i++)
        {
            posicionY += delta;
            draw();
        }
    }

    /**
     * Cambia el tamaño (en píxeles). Debe ser >= 0.
     */
    public void changeSize(Integer newAlto, Integer newAncho)
    {
        erase();
        alto = newAlto;
        ancho = newAncho;
        draw();
    }

    /**
     * Cambia el color. Los colores válidos son "red", "yellow", "blue",
     * "green", "magenta" y "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Dibuja el triángulo en la pantalla según especifica su estado.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { posicionX, posicionX + (ancho/2), posicionX - (ancho/2) };
            int[] ypoints = { posicionY, posicionY + alto, posicionY + alto };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /**
     * Borra el triángulo de la pantalla.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
