
public class Player 
{
    private String nickname;
    private Integer level;
    private static Integer globalID = 1;
    private Integer idUser = 0;


    public Player(String nickname, Integer level)
    {
        this.nickname = nickname;
        this.level = level;
        idUser = globalID++;
    }

    public String toString()
    {
        return "[ID: " + idUser + "] " + nickname + " (Lvl: " + level + ")";
    }

    public String getNickName()
    {
        return nickname;
    }

    public Integer getLvl()
    {
        return level;
    }


}
