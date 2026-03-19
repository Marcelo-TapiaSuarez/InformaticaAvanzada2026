import java.awt.*;

/**
 * Un cuadrado que se puede modificar y que se dibuja a sí mismo en un canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29

 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */

public class Cuadrado
{
    private Integer lado;
    private Integer posicionX;
    private Integer posicionY;
    private String  color;
    private Boolean isVisible;

    /**
     * Crea un nuevo cuadrado en una posición y color por defecto.
     */
    public Cuadrado()
    {
        lado = 60;
        posicionX = 310;
        posicionY = 120;
        color = "red";
        isVisible = false;
    }

    /**
     * Hace visible a este cuadrado. Si ya está visible, no hace nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Hace invisible a este cuadrado. Si ya está visible, no hace nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Mueve el cuadrado unos pocos píxeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mueve el cuadrado unos pocos píxeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mueve el cuadrado unos pocos píxeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mueve el cuadrado unos pocos píxeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mueve el cuadrado horizontalmente 'distancia' píxeles.
     */
    public void moverHorizontal(Integer distancia)
    {
        erase();
        posicionX += distancia;
        draw();
    }

    /**
     * Mueve el cuadrado verticalmente 'distancia' píxeles.
     */
    public void moverVertical(Integer distancia)
    {
        erase();
        posicionY += distancia;
        draw();
    }

    /**
     * Mueve lentamente el cuadrado horizontalmente 'distancia' píxeles.
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
     * Mueve lentamente el cuadrado verticalmente 'distancia' píxeles.
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
    public void changeSize(Integer newLado)
    {
        erase();
        lado = newLado;
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
     * Dibuja el cuadrado en la pantalla según especifica su estado.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(posicionX, posicionY, lado, lado));
            canvas.wait(10);
        }
    }

    /**
     * Borra el cuadrado de la pantalla.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
