package DesignPatterns.proxyPattern;

public class LionProxy implements Animal {
    Lion lion;

    public LionProxy() {
        this.lion = new Lion();
    }

    @Override
    public void speak() {
        System.out.println("Before speak method from parent");
        lion.speak();
        System.out.println("After speak method from parent");
    }
}
