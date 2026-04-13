
import java.util.Random;

public class Persona {
    //Constantes
    /**
     * Sexo por defecto
     */
    private final char sexo_defecto = 'H';
    
    //Atributos
    private String nombre;
    private int edad;
    private int DNI;
    private char sexo;
    private double peso;
    private double altura;
    
    //Contructores
    
    /**
     * Constructor por defecto
     */
    public Persona() {sexo=sexo_defecto;}

    /**
     * Constructor con 3 parametroe
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     */
    public Persona(String nombre, int edad, char sexo) 
    {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        generarDni();
    }

    /**
     * Constructor con 5 parametros
     *
     * @param nombre de la persona
     * @param edad de la persona
     * @param sexo de la persona
     * @param peso de la persona
     * @param altura de la persona
     */
    public Persona(String nombre, int edad, char sexo, double peso, double altura) 
    {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        generarDni();
    }

    // Usando la Clase Random.
    private void generarDni() 
    {
        DNI = new Random().nextInt(100000000)+35000000;
    }


    //Metodos publicos
    /**
     * Modifica el nombre de la persona
     *
     * @param nombre a cambiar
     */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * Modifica la edad de la persona
     *
     * @param edad a cambiar
     */
    public void setEdad(int edad) 
    {
        this.edad = edad;
    }

    /**
     * Modifica el sexo de la persona, comprueba que es correcto
     *
     * @param sexo a cambiar
     */
    public void setSexo(char sexo) 
    {
        this.sexo = sexo;
    }

    /**
     * Modifica el peso de la persona
     *
     * @param peso a cambiar
     */
    public void setPeso(double peso) 
    {
        this.peso = peso;
    }

    /**
     * Modifica la altura de la persona
     *
     * @param altura a cambiar
     */
    public void setAltura(double altura) 
    {
        this.altura = altura;
    }

    /**
     * Calcula el indice de masa corporal
     *
     * @return IMC.INFRAPESO: la persona esta por debajo de su peso ideal
     * IMC.PESO_IDEAL: la persona esta en su peso ideal
     * IMC.SOBREPESO: la persona esta por encima de su peso ideal
     */
    public IMC calcularIMC() 
    {
        double imc = peso/Math.pow(altura, 2);

        if(imc < 20)
        {
            return IMC.INFRAPESO;
        }
        else if(imc > 25)
        {
            return IMC.SOBREPESO;
        }

        return IMC.PESO_IDEAL;
    }

    /**
     * Indica si la persona es mayor de edad
     *
     * @return true si es mayor de edad y false es menor de edad
     */
    public boolean esMayorDeEdad() 
    {
        return edad >= 18 ? true : false;
    }

    /**
     * Devuelve informacion del objeto
     *
     * @return cadena con toda la informacion
     */
    @Override
    public String toString() 
    {
        return "Nombre: " + nombre +
               "\nSexo: " + (sexo == 'H' ? "hombre" : "mujer") +
               "\nEdad: " + edad + " anios" +
               "\nDNI: " + DNI +
               "\nPeso: " + peso + " kg" +
               "\nAltura: " + altura + " metros";
    }

}