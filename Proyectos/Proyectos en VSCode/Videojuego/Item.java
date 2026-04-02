
public class Item
{
    private String name;
    private String category;
    private Integer weight;
    
    public Item(String name, String category, Integer weight)
    {
        this.name = name;
        this.category = category;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public Integer getWeight()
    {
        return weight;
    }
}
