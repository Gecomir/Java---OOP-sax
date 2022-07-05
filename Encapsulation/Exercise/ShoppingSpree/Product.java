package Encapsulation.ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getCost() {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        return cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }
}
