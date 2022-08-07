package DesignPatterns.iteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Horse");
        animals.add("Monkey");

        Iterator<String> iterator = animals.iterator();
//        iterator.hasNext()
        iterator.next();
    }
}

