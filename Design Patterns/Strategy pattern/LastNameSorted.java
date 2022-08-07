package DesignPatterns.strategyPattern;

import java.util.Collections;
import java.util.Comparator;

public class LastNameSorted implements Comparator<Person> {

    @Override
    public int compare(Person left, Person right) {
        return left.getLastName().compareTo(right.getLastName());
    }

    public Comparator<Person> reversed(){
        return Collections.reverseOrder(this);
    }
}
