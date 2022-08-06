package DesignPatterns.factoryExercise.cake;

public class CakeFactory {
    public static Cake createCake(String cakeType) {
        Cake cake = null;
        switch (cakeType) {
            case "Spinach":
                cake = new SpinachCake(12, 12, 12);
                break;
            case "Chocolate":
                cake = new ChocolateCake(10, 18, 20);
                break;
            case "Biscuit":
                cake = new BiscuitCake(8, 10, 14);
                break;
            case "White":
                cake = new WhiteCake(10, 13, 15);
                break;
        }
        return cake;
    }
}
