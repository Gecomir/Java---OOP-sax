package ReflectionAndAnnotation.barracksWars;

import ReflectionAndAnnotation.barracksWars.core.Engine;
import ReflectionAndAnnotation.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.barracksWars.data.UnitRepository;
import ReflectionAndAnnotation.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
