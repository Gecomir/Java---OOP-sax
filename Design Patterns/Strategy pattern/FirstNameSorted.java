package DesignPatterns.strategyPattern;

import java.util.Comparator;

public class FirstNameSorted implements Comparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return left.getFirstName().compareTo(right.getFirstName());
    }
}
