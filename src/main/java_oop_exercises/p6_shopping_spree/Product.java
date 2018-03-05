package p6_shopping_spree;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
        else
            throw new IllegalArgumentException("Name cannot be empty");
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost >= 0)
            this.cost = cost;
        else
            throw new IllegalArgumentException("Money cannot be negative");
    }
}
