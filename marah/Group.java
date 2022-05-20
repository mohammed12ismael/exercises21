package marah;

import java.util.Scanner;

public class Group
{
    public Team[] teams;
    private boolean[][] matches;
    private static int numOfTeams = 4;

    public Group()
    {
        teams = new Team[numOfTeams];
        matches = new boolean[numOfTeams][numOfTeams];
    }

    public void addTeam(Team team)
    {
        int i;
        for (i = 0; i < teams.length && teams[i] != null; i++);
        teams[i] = team;
    }

    public void printTeamsPoint()
    {
        System.out.printf("%30s%30s", "Team-Name", "Team-Points");
        for (int i = 0; i < teams.length && teams[i] != null; i++)
            System.out.printf("%30s%30s\n", teams[i].name, teams[i].getPoints());
    }

    public int unplayedMatches()
    {
        int total = 0;
        for (int i = 0; i < matches.length; i++)
        {
            for (int j = 0; j < matches[i].length; j++)
            {
                if (i != j && !matches[i][j])
                    total++;
            }
        }
        return total;
    }

    public String qualifiedTeams()
    {
        Team max1 = teams[0], max2 = teams[0];
        for (int i = 0; i < teams.length; i++)
        {
            if (teams[i].getPoints() > max2.getPoints())
            {
                if (teams[i].getPoints() > max1.getPoints())
                    max1 = teams[i];
                else
                    max2 = teams[i];
            }
        }

        return max1.name  + ", " + max2.name;
    }

    public static int getNumOfTeams()
    {
        return numOfTeams;
    }

    public static void setNumOfTeams(int numOfTeams_)
    {
        numOfTeams = numOfTeams_;
    }

    public Team playNextMatch()
    {
        int host = 0, quest = 0;
        boolean found = false;
        for (int i = 0; i < matches.length && !found; i++)
        {
            for (int j = 0; j < matches[i].length; j++)
            {
                if (i != j && !matches[i][j])
                {
                    matches[i][j] = true;
                    host = i;  quest = j;
                    found = true;
                    break;
                }
            }
        }

        System.out.printf("%30s\n", "Match Started");

        System.out.println("Host Team: ........(" + teams[host].name + ").........");
        System.out.println("Host Team: ........(" + teams[quest].name + ").........");

        int hostGoals = 0, questGoals = 0;
        int winner = 0;
        System.out.println("What Happened");
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("1.A goal is Scored");
            System.out.println("2.The match ended");

            int choice = scanner.nextInt();

            if (choice == 1)
            {
                System.out.print("Which Team Scored 1.Host 2.Quest: ");
                int whoScore = scanner.nextInt();
                System.out.println("Enter the number of The Player Who Scored: ");
                int playerNumber = scanner.nextInt();

                if (whoScore == 1)
                {
                    hostGoals++;
                    Player[] players = teams[host].getPlayers();
                    for (int i = 0; i < players.length; i++)
                    {
                        if (players[i].number == playerNumber)
                            players[i].incrementGoals();
                    }
                }
                else
                {
                    questGoals++;
                    Player[] players = teams[quest].getPlayers();
                    for (int i = 0; i < players.length; i++)
                    {
                        if (players[i].number == playerNumber)
                            players[i].incrementGoals();
                    }
                }
            }
            else
            {
                if (hostGoals > questGoals)
                {
                    System.out.println(teams[host].name + " wins!");
                    teams[host].incrementPoint(3);
                    winner = host;
                }
                else if (hostGoals < questGoals)
                {
                    System.out.println(teams[quest].name + " wins!");
                    teams[quest].incrementPoint(3);
                    winner = quest;
                }
                else
                {
                    System.out.println("It`s a draw!");
                    teams[host].incrementPoint(1);
                    teams[quest].incrementPoint(1);
                }
                break;
            }
        }
        return teams[winner];
    }

}
