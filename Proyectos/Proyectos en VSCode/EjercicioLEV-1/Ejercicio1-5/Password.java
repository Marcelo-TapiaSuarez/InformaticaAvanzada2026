import java.util.Random;

public class Password {

    //Constantes
    /**
     * Longitud por defecto
     */
    private final int longitud_default = 8;


    //Atributos
    /**
     * Longitud de la contrasenia
     */
    private int longitud;
    /**
     * caracteres de la contrasenia
     */
    private String contrasenia;

    private Random rand = new Random();
    //Constructor
    /**
     * La contrasenia sera la pasada por parametro
     * @param contrasenia
     */
    public Password (String contrasenia)
    {
        this.contrasenia = contrasenia;
        longitud = longitud_default;
    }

    /**
     * La longitud sera la pasada por parametro
     * @param longitud
     */
    public Password (int longitud)
    {
        this.longitud = longitud;
        generaPassword();     
    }

    //Metodos publicos
    /**
     * Devuelve la longitud
     * @return longitud de la contrasenia
     */
    public int getLongitud() 
    {
        return longitud;
    }

    /**
     * Modifica la longitud de la contrasenia
     * @param longitud a cambiar
     */
    public void setLongitud(int longitud) 
    {
        this.longitud = longitud;
    }

    /**
     * Devuelve la contrasenia
     * @return contrasenia
     */
    public String getContrasenia() 
    {
        return contrasenia;
    }

    /**
     * Comprueba la fortaleza de la contrasenia
     * @return
     */
    public boolean esFuerte()
    {
        char pass[] = contrasenia.toCharArray();
        int n=0;
        int m=0;
        int M=0;

        for(int i=0; i < longitud; i++)
        {
            if(pass[i] >= 48 && pass[i] <= 57)
            {
                n++;
            }
            else if(pass[i] >= 65 && pass[i] <= 90)
            {
                M++;
            }
            else if(pass[i] >= 97 && pass[i] <= 122)
            {
                m++;
            }
        }

        return n > 5 && m > 1 && M > 2 ? true : false;
    }

    /**
     * Genera una contrasenia al azar con la longitud que este definida
     * @return contrasenia
     */
    public String generaPassword ()
    {
        char pass[] = new char[longitud];
        int dice = rand.nextInt(3);
        int randNum;
        int randMay;
        int randMin;
        
        for(int i=0; i < longitud; i++)
        {
            if(dice == 0)
            {
                randNum = rand.nextInt(10)+48;
                pass[i] = (char) randNum;
            }
            if(dice == 1)
            {
                randMay = rand.nextInt(26)+65;
                pass[i] = (char) randMay;
            }
            if(dice == 2)
            {
                randMin = rand.nextInt(26)+97;
                pass[i] = (char) randMin;
            }
            dice = rand.nextInt(3);
        }

        contrasenia = new String(pass);
        
        return contrasenia;
    }

}

