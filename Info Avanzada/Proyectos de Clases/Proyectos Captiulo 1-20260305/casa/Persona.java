import java.awt.*;

/**
 * Una persona que se puede modificar y que se dibuja a sí mismo en un canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29

 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */

public class Persona
{
    private Integer alto;
    private Integer ancho;
    private Integer posicionX;
    private Integer posicionY;
    private String  color;
    private Boolean isVisible;

    /**
     * Crea una nueva persona en una posición y color por defecto.
     */
    public Persona()
    {
        alto = 60;
        ancho = 30;
        posicionX = 280;
        posicionY = 190;
        color = "black";
        isVisible = false;
    }

    /**
     * Hace visible a esta persona. Si ya está visible, no hace nada.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Hace invisible a esta persona. Si ya está visible, no hace nada.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Mueve la persona unos pocos píxeles a la derecha.
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mueve la persona unos pocos píxeles a la izquierda.
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mueve la persona unos pocos píxeles hacia arriba.
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mueve la persona unos pocos píxeles hacia abajo.
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mueve la persona horizontalmente 'distancia' píxeles.
     */
    public void moverHorizontal(Integer distancia)
    {
        erase();
        posicionX += distancia;
        draw();
    }

    /**
     * Mueve la persona verticalmente 'distancia' píxeles.
     */
    public void moverVertical(Integer distancia)
    {
        erase();
        posicionY += distancia;
        draw();
    }

    /**
     * Mueve lentamente la persona horizontalmente 'distancia' píxeles.
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
     * Mueve lentamente la persona verticalmente 'distancia' píxeles.
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
     * Dibuja la persona en la pantalla según especifica su estado.
     */
    private void draw()
    {
        int bh = (int)(alto * 0.7);  // body height
        int hh = (alto - bh) / 2;  // half head height
        int hw = ancho / 2;  // half width
        int x = posicionX;
        int y = posicionY;
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { x-3, x-hw, x-hw, x-(int)(hw*0.2)-1, x-(int)(hw*0.2)-1, x-hw, 
                              x-hw+(int)(hw*0.4)+1, x, x+hw-(int)(hw*0.4)-1, x+hw, x+(int)(hw*0.2)+1, 
                              x+(int)(hw*0.2)+1, x+hw, x+hw, x+3, x+(int)(hw*0.6), 
                              x+(int)(hw*0.6), x+3, x-3, x-(int)(hw*0.6), x-(int)(hw*0.6) };
            int[] ypoints = { y, y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
                              y+(int)(bh*0.5), y+bh, y+bh, y+(int)(bh*0.65), y+bh, y+bh, 
                              y+(int)(bh*0.5), y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
                              y, y-hh+3, y-hh-3, y-hh-hh, y-hh-hh, y-hh-3, y-hh+3 };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 21));
            canvas.wait(10);
        }
    }

    /**
     * Borra la persona de la pantalla.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
