import java.util.Random;

public class Id 
{
    private Integer id;

    public Id ()
    {
        setId();
    }
    
    private Integer setId()
    {
        this.id = new Random().nextInt();
        
        if(id < 0 || id > 10000)
        {
            setId();
        }
        return id;
    }

    public Integer getId()
    {
        return id;
    }
}
