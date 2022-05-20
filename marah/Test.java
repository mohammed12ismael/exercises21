package marah;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of teams: ");
        int teamsCount = scanner.nextInt();

        while (teamsCount % Group.getNumOfTeams() != 0)
        {
            System.out.print("Enter Number of teams: ");
            teamsCount = scanner.nextInt();
        }

        Team[] teams = new Team[teamsCount];

        for (int i = 0; i < teamsCount; i++)
            teams[i] = new Team();

        shuffle(teams);
        Group[] groups = new Group[teamsCount / Group.getNumOfTeams()];

        for (int i = 0; i < groups.length; i++)
            groups[i] = new Group();

        int index = 0, divider = 0;
        for (int i = 0; i < teams.length; i++)
        {
            if (divider == 4)
            {
                divider = 1;
                index++;
            }
            groups[index].addTeam(teams[i]);
            divider++;
        }


        for (int i = 0; i < groups.length; i++)
        {
            System.out.println(groups[i].unplayedMatches());
            while (groups[i].unplayedMatches() != 0)
                groups[i].playNextMatch();
        }

        for (int i = 0; i < groups.length; i++)
            System.out.println("Group-" + i + " :......" +  groups[i].qualifiedTeams());
    }

    public static void shuffle(Team[] teams)
    {
        for (int i = 0 ; i < teams.length; i++)
        {
            int index = (int) ((Math.random() * (teams.length * 2)) % teams.length);
            Team temp = teams[i];
            teams[i] = teams[index];
            teams[index] = temp;
        }
    }
}
