package p6_shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> products;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0)
            this.money = money;
        else
            throw new IllegalArgumentException("Money cannot be negative");
    }

    public void buyProduct(Product product){
        if (product.getCost() <= this.money){
            this.products.add(product);
            this.setMoney(this.money - product.getCost());
            System.out.println(String.format("%s bought %s", this.name, product.getName()));
        }else{
            System.out.println(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        int numOfProducts = this.products.size();

        if (this.products.size() == 0)
            return sb.append("Nothing bought\n").toString();

        for (int i = 0; i < numOfProducts; i++) {
            String nameOfProd = this.products.get(i).getName();

            if (i < numOfProducts-1)
                sb.append(nameOfProd).append(", ");
            else
                sb.append(nameOfProd).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
