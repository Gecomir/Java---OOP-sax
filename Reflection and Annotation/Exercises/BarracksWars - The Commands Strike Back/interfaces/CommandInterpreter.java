package ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
