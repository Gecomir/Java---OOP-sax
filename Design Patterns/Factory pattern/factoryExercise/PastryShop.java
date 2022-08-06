package DesignPatterns.factoryExercise;

import DesignPatterns.factoryExercise.cake.Cake;
import DesignPatterns.factoryExercise.cake.CakeFactory;

public class PastryShop {
    public static Cake orderCake(String cakeType){
        Cake cake = CakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();
        return cake;
    }
}
