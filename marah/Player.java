package marah;

import java.util.Scanner;

public class Player
{
    public String name;
    public int number;
    private int goals = 0;


    public Player()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.next();

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();


        this.name = name;
        this.number = number;
    }

    public Player(String name, int number)
    {
        this.name = name;
        this.number = number;
    }


    public void incrementGoals()
    {
        goals++;
    }

    public int getGoals()
    {
        return goals;
    }


    // copy object
    public Player getCopy()
    {
        return new Player(name, number);
    }
}
