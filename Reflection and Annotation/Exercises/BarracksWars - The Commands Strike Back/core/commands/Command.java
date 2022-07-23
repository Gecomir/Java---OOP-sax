package ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Executable;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private final String[] data;
    private final Repository repository;
    private final UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

}
