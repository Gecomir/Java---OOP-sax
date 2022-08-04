package ReflectionAndAnnotation.barracksWarsDependencies.core.commands;

import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.Executable;


public abstract class Command implements Executable {
    private final String[] data;


    protected Command(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return this.data;
    }

}
