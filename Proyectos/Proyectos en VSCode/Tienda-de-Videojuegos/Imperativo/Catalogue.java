package Imperativo;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;

public class Catalogue 
{
    private HashMap<String, Double> catalogue;
    private TreeSet<String> gameList;
    private Iterator<String> it;

    public Catalogue()
    {
        catalogue = new HashMap<>();
        it = catalogue.keySet().iterator();
        gameList = new TreeSet<>();
    }

    public void setCatalogue(String game, Double price)
    {
        catalogue.put(game, price);
    }

    public void printCatalogue()
    {
        catalogue.keySet().forEach(System.out::println);
    }

    public String getGame(String name)
    {
        return catalogue.containsKey(name) ? name : null;
    }

    public Double getPrice(String name)
    {
        return catalogue.containsKey(name) ? catalogue.get(name) : null;
    }

    public TreeSet<String> getGameList()
    {
        while(it.hasNext())
        {
            gameList.add(it.next().toString());
        }
        return gameList;
    }
}
