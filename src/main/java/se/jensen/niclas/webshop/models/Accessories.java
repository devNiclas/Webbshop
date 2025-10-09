package se.jensen.niclas.webshop.models;

import se.jensen.niclas.webshop.Product;

public class Accessories extends Product {
    public Accessories(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Accessoarer";
    }
}
