package ReflectionAndAnnotation.barracksWarsDependencies;

import ReflectionAndAnnotation.barracksWarsDependencies.core.Engine;
import ReflectionAndAnnotation.barracksWarsDependencies.core.factories.CommandInterpreterImpl;
import ReflectionAndAnnotation.barracksWarsDependencies.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.barracksWarsDependencies.data.UnitRepository;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.Repository;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        final Engine engine = new Engine(commandInterpreter);

        engine.run();
    }

}
