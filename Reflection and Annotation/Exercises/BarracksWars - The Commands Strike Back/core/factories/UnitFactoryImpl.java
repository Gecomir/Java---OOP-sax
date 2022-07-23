package ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.core.factories;

import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.BarracksWars_TheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    @SuppressWarnings("all")
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

       return createUnit(unitClass);

    }

    private Unit createUnit(Class<Unit> unitClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       final Constructor<Unit> ctors = unitClass.getDeclaredConstructor();
       ctors.setAccessible(true);

       return ctors.newInstance();
    }

}
