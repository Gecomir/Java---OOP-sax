package ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars;

import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.core.Engine;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.data.UnitRepository;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
