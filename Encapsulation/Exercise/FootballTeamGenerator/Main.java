package Encapsulation.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teamsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            try {
                String[] commandParts = input.split(";");
                String commandName = commandParts[0];
                String teamName = commandParts[1];

                switch (commandName) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamsMap.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = commandParts[2];
                        int endurance = Integer.parseInt(commandParts[3]);
                        int sprint = Integer.parseInt(commandParts[4]);
                        int dribble = Integer.parseInt(commandParts[5]);
                        int passing = Integer.parseInt(commandParts[6]);
                        int shooting = Integer.parseInt(commandParts[7]);


                        if (!teamsMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamsMap.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        String playerToRemove = commandParts[2];
                        if (!teamsMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            teamsMap.get(teamName).removePlayer(playerToRemove);
                        }
                        break;
                    case "Rating":
                        if (!teamsMap.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamsMap.get(teamName).getRatting()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }


    }
}
