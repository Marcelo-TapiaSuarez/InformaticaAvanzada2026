import java.util.HashSet;
import java.util.HashMap;

public class Clan 
{
    private HashSet<Player> members;
    private HashMap<String, Player> directory;


    public Clan()
    {
        members = new HashSet<>();
        directory = new HashMap<>();
    }

    /**
     * Añade jugador al clan.
     * @param p Recibe un jugador registrado.
     */
    public void setPlayer(Player p)
    {
        members.add(p);
        directory.put(p.getNickName(), p);
    }

    /**
     * Imprime la lista de miembros del clan.
     */

    public void printList()
    {
        members.stream().forEach(System.out::println);
    }

    /**
     * Devuelve el nivel promedio de los miembros del clan.
     * @return Nivel promedio.
     */

    public Integer averageLvl()
    {
        return !members.isEmpty() ? members.stream().mapToInt(player -> player.getLvl()).sum()/members.size() : 0;
    }
}
