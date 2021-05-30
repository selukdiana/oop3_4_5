package hierarchy;

import java.io.Serializable;

public class BasicPropertyProduct implements Serializable {
    private String country;
    private double price;
    private int shelf_life;
    private String color;

    public BasicPropertyProduct() {
        country = "";
        price = 0;
        shelf_life = 0;
        color = "";
    }

    public BasicPropertyProduct(String country, double price, int shelf_life, String color) {
        this.country = country;
        this.price = price;
        this.shelf_life = shelf_life;
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(int shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return country + "-%-" + price + "-%-" + shelf_life + "-%-" + color;
    }
}
