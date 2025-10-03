package se.jensen.niclas.webshop.models;

import se.jensen.niclas.webshop.Product;

public class Shoes extends Product {

    public Shoes(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Skor:";

    }
}
