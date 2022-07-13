package InterfacesAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> listOfWantEnter = new ArrayList<>();

        String peopleWantEnter;
        Identifiable peopleToEnter = null;

        while (!"End".equals(peopleWantEnter = scanner.nextLine())){
            String[] peopleFromConsole = peopleWantEnter.split("\\s+");
            String nameModel = peopleFromConsole[0];

            if(peopleFromConsole.length == 2) {
                peopleToEnter = new Robot(peopleFromConsole[1], nameModel);
            } else {
                peopleToEnter = new Citizen(nameModel, Integer.parseInt(peopleFromConsole[1]), peopleFromConsole[2]);
            }
            listOfWantEnter.add(peopleToEnter);
        }

        String idEnds = scanner.nextLine();

        listOfWantEnter.stream().filter(s -> s.getId().endsWith(idEnds)).forEach(s -> System.out.println(s.getId()));

    }
}
