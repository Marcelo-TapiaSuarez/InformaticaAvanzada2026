/**
 * Esta clase representa un dibujo simple. Usted puede dibujar la imagen
 * usando el método draw(). Pero espere, hay mucho más: por tratarse de una
 * imagen electrónica, se puede modificar. Puede convertirla a blanco y negro
 * y volverla a color (primero tiene que estar dibujada, por supuesto).
 * 
 * Esta clase se escribió como un primer ejemplo paa enseñar Java con BlueJ. 

 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @translation Maximiliano Andrés Eschoyez y Martín Federico Pelliza (2025)
 */
public class Cuadro
{
    private Cuadrado pared;
    private Cuadrado ventana;
    private Triangulo techo;
    private Circulo sol;
    private Boolean dibujado;

    /**
     * Constructor de los objetos usados por la clase Cuadro.
     */
    public Cuadro()
    {
        pared = new Cuadrado();
        ventana = new Cuadrado();
        techo = new Triangulo();  
        sol = new Circulo();
        dibujado = false;
    }

    /**
     * Dibujar esta imagen.
     */
    public void draw()
    {
        if(!dibujado) {
            pared.moverHorizontal(-140);
            pared.moverVertical(20);
            pared.changeSize(120);
            pared.makeVisible();
            
            ventana.changeColor("black");
            ventana.moverHorizontal(-120);
            ventana.moverVertical(40);
            ventana.changeSize(40);
            ventana.makeVisible();
    
            techo.changeSize(60, 180);
            techo.moverHorizontal(20);
            techo.moverVertical(-60);
            techo.makeVisible();
    
            sol.changeColor("yellow");
            sol.moverHorizontal(100);
            sol.moverVertical(-40);
            sol.changeSize(80);
            sol.makeVisible();
            dibujado = true;
        }
    }

    /**
     * Cambiar esta imagen del display a blanco y negro.
     */
    public void setBlancoYNegro()
    {
        pared.changeColor("black");
        ventana.changeColor("white");
        techo.changeColor("black");
        sol.changeColor("black");
    }

    /**
     * Cambiar esta imagen del display a color.
     */
    public void setColor()
    {
        pared.changeColor("red");
        ventana.changeColor("black");
        techo.changeColor("green");
        sol.changeColor("yellow");
    }
}
