import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Canvas es una clase que permite hacer dibujos simples en una ventana.
 * Es una modificación de un canvas de propósito general, especialmente
 * hecho para el ejemplo "figuras" con BlueJ.
 *
 * @author: Bruce Quig
 * @author: Michael Kölling (mik)
 *
 * @version 2016.02.29
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */
public class Canvas
{
    // Nota: La implementación de esta clase es levemente más compleja de lo
    // necesario (específicamente la gestión de la identidad de las formas y
    // sus colores). Esto se hizo con el propósito de mantener claras y simples
    // las interfaces y campos de las instancias de los objetos de las formas
    // de este proyecto con fines educativos.

    private static Canvas canvasSingleton;

    /**
     * Método Factory para obtener el objeto canvas singleton.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("Demo Figuras BlueJ", 500, 300, 
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- parte de la instancia -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D grafico;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objetos;
    private HashMap<Object, ShapeDescription> figuras;
    
    /**
     * Crea un Canvas.
     * 
     * @param titulo  título del Canvas Frame
     * @param ancho   el ancho deseado para el canvas
     * @param alto    el alto deseado para el canvas
     * @param bgColor el color de fondo deseado para el canvas
     */
    private Canvas(String titulo, Integer ancho, Integer alto, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(titulo);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(ancho, alto));
        backgroundColor = bgColor;
        frame.pack();
        objetos = new ArrayList<Object>();
        figuras = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Setea la visibilidad del canvas y lo coloca en el frente de la
     * pantalla cuando está visible. Este método puede usarse también
     * para traer un canvas al frente de otra ventana.
     * 
     * @param visible  valor booleano que representa la visibilidad
     * deseada del canvas (true or false) 
     */
    public void setVisible(Boolean visible)
    {
        if(grafico == null) {
            // La primera llamada crea una instancia de la imagen fuera
            // de la pantalla y la rellena con el color de fondo.
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            grafico = (Graphics2D)canvasImage.getGraphics();
            grafico.setColor(backgroundColor);
            grafico.fillRect(0, 0, size.width, size.height);
            grafico.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Dibuja en el canvas la figura deseada.
     * 
     * @param  objetoReferencia  un objeto que define la identidad de esta figura
     * @param  color             el color de la figura
     * @param  forma             el objeto figura a dibujar en el canvas
     */
     // Nota: La implementación de la gestión de los objetos figura no es la más
     // apropiada. Se diseñó de esta forma para mantener visibles las interfaces
     // de las figuras en forma clara y simple con obejtivos educativos.
    public void draw(Object objetoReferencia, String color, Shape forma)
    {
        objetos.remove(objetoReferencia);   // solo en caso que fue agregada antes
        objetos.add(objetoReferencia);      // agregar al final
        figuras.put(objetoReferencia, new ShapeDescription(forma, color));
        redraw();
    }
 
    /**
     * Borra de la pantalla la figura indicada.
     * .
     * @param  objetoReferencia  el objeto figura a borrar 
     */
    public void erase(Object objetoReferencia)
    {
        objetos.remove(objetoReferencia);   // solo en caso que esté en la lista
        figuras.remove(objetoReferencia);
        redraw();
    }

    /**
     * Setea el color del frente del Canvas.
     * 
     * @param  newColor   el nuevo color para el frente del Canvas 
     */
    public void setForegroundColor(String colorString)
    {
        if(colorString.equals("red")) {
            grafico.setColor(new Color(235, 25, 25));
        }
        else if(colorString.equals("black")) {
            grafico.setColor(Color.black);
        }
        else if(colorString.equals("blue")) {
            grafico.setColor(new Color(30, 75, 220));
        }
        else if(colorString.equals("yellow")) {
            grafico.setColor(new Color(255, 230, 0));
        }
        else if(colorString.equals("green")) {
            grafico.setColor(new Color(80, 160, 60));
        }
        else if(colorString.equals("magenta")) {
            grafico.setColor(Color.magenta);
        }
        else if(colorString.equals("white")) {
            grafico.setColor(Color.white);
        }
        else {
            grafico.setColor(Color.black);
        }
    }

    /**
     * Espera los milisegundos indicados antes de finalizar. Esta es
     * una forma simple de generar una pequeña demora para utilizar
     * cuando se desee producir animaciones.
     * 
     * @param  milisegundos  la cantidad de milisegundos
     */
    public void wait(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (Exception e)
        {
            // ignoramos la excepcion
        }
    }

    /**
     * Redibujar todas las figuras en el Canvas actual.
     */
    private void redraw()
    {
        erase();
        for(Object forma : objetos) {
            figuras.get(forma).draw(grafico);
        }
        canvas.repaint();
    }
       
    /**
     * Borrar todo el canvas. (No se vuelve a dibujar.)
     */
    private void erase()
    {
        Color original = grafico.getColor();
        grafico.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        grafico.fill(new Rectangle(0, 0, size.width, size.height));
        grafico.setColor(original);
    }


    /************************************************************************
     * Clase interna CanvasPane - el componente canvas contenido en el
     * frame Canvas. Esencialmente es un JPanel con capacidades adicionales
     * para refrescar la imagen dibujada.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /************************************************************************
     * Clase interna CanvasPane - el componente canvas contenido en el
     * frame Canvas. Esencialmente es un JPanel con capacidades adicionales
     * para refrescar la imagen dibujada.
     */
    private class ShapeDescription
    {
        private Shape forma;
        private String colorString;

        public ShapeDescription(Shape forma, String color)
        {
            this.forma = forma;
            colorString = color;
        }

        public void draw(Graphics2D grafico)
        {
            setForegroundColor(colorString);
            grafico.fill(forma);
        }
    }

}
