package barracksWars.core.factories;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.CommandFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactoryImpl implements CommandFactory {

    private static final String COMMANDS_PACKAGE_NAME = "core.commands.";

    @SuppressWarnings("all")
    public Command createCommand(String commandName, String[] data) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, InvocationTargetException {

        Class<Command> commandClass = (Class<Command>) Class.forName(COMMANDS_PACKAGE_NAME + commandName);

        Constructor<Command> commandConstructor = commandClass.getDeclaredConstructor(String[].class);
        commandConstructor.setAccessible(true);

        return commandConstructor.newInstance(new Object[]{data});
    }
}

