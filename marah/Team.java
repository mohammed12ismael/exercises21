package marah;

import java.util.Scanner;

public class Team
{
    public String name;
    private Player[] players;
    private int points;

    public Team()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the team: ");
        String name = scanner.next();

        System.out.print("Enter The Number Of Players: ");
        int size = scanner.nextInt();

        this.name = name;

        players = new Player[size];

        for (int i = 0; i < size; i++)
            players[i] = new Player();
    }

    public Team(String name, Player[] players)
    {
        this.name = name;
        this.players = players;
    }

    public Player[] getPlayers()
    {
        Player[] out = new Player[players.length];
        for (int i = 0; i < out.length; i++)
            out[i] = players[i].getCopy();
        return out;
    }

    public void incrementPoint(int amount)
    {
        if (amount == 1 || amount == 3)
            points += amount;
        else
            System.out.println("Failed to Increment Points");
    }

    public int getPoints()
    {
        return points;
    }
}
