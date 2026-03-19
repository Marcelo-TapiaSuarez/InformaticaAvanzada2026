import java.awt.geom.*;

/**
 * Un círculo que se puede modificar y que se dibuja a sí mismo en un canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */

public class Circulo
{
    private Integer diametro;
    private Integer posicionX;
    private Integer posicionY;
    private String  color;
    private Boolean isVisible;

    /**
     * Crea un nuevo circulo en una posición y color por defecto.
     */
    public Circulo()
    {
        diametro = 68;
        posicionX = 230;
        posicionY = 90;
        color = "blue";
        isVisible = false;
    }

    /**
     * Hace visible a este círculo. Si ya está visible, no hace nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Hace invisible a este círculo. Si ya está visible, no hace nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Mueve el círculo unos pocos píxeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mueve el círculo unos pocos píxeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mueve el círculo unos pocos píxeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mueve el círculo unos pocos píxeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mueve el círculo horizontalmente 'distancia' píxeles.
     */
    public void moverHorizontal(Integer distancia)
    {
        erase();
        posicionX += distancia;
        draw();
    }

    /**
     * Mueve el círculo verticalmente 'distancia' píxeles.
     */
    public void moverVertical(Integer distancia)
    {
        erase();
        posicionY += distancia;
        draw();
    }

    /**
     * Mueve lentamente el círculo horizontalmente 'distancia' píxeles.
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
     * Mueve lentamente el círculo verticalmente 'distancia' píxeles.
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
    public void changeSize(Integer newDiametro)
    {
        erase();
        diametro = newDiametro;
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
     * Dibuja el círculo en la pantalla según especifica su estado.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(posicionX, posicionY, 
                                                          diametro, diametro));
            canvas.wait(10);
        }
    }

    /**
     * Borra el círculo de la pantalla.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
