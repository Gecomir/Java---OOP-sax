package ReflectionAndAnnotation.barracksWarsDependencies.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);

    Executable interpretCommand(String[] data);
}
