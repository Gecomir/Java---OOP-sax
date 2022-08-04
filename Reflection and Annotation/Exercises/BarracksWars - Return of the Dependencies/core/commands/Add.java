package ReflectionAndAnnotation.barracksWarsDependencies.core.commands;

import ReflectionAndAnnotation.barracksWarsDependencies.annotations.Inject;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.Repository;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.Unit;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException,
            ExecutionControl.NotImplementedException {

        final String unitType = getData()[1];

        final Unit unitToAdd = this.unitFactory.createUnit(unitType);

        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }

}
