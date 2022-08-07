package DesignPatterns.strategyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Person person = new Person("Georgi", "Ivanov");
        Person person1 = new Person("Petar", "Petrov");
        Person person2 = new Person("Ivan", "Georgiev");
        Person person3 = new Person("Stela", "Dimitrova");

        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        Collections.sort(personList, new LastNameSorted());
        Collections.sort(personList, new FirstNameSorted().reversed());
    }
}
