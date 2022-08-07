package DesignPatterns.builderExercise.builderExamp;

public class Main {
    public static void main(String[] args) {

        Person person = Person.builder()
                .withAddress("Sofia")
                .withFirstName("Georgi")
                .build();
    }
}
