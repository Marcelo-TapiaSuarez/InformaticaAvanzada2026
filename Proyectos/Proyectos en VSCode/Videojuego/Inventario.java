import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inventario 
{
    private ArrayList<Item> inventory;

    public Inventario()
    {
        inventory = new ArrayList<>();
    }

    public void newItem(Item item)
    {
        inventory.add(item);
    }

    public Integer getTotalWeight()
    {
        return inventory.stream().map(Item::getWeight).reduce(0, (a,b)->a+b);
    }

    public ArrayList<String> getWeapon()
    {
        return inventory.stream().filter(i -> i.getCategory().equals("Weapon")).map(Item::getName).collect(Collectors.toCollection(ArrayList<String>::new));
    }

    public Boolean mostHeavy()
    {
        return inventory.stream().anyMatch(i -> i.getWeight() > 50);
    }


}
