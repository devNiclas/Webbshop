package se.jensen.niclas.webshop;

public abstract class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }


    public String getTitle() {
        return title;
    }


    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }


    public abstract String category();

    // Returnerar hur objektet skrivs till text i fil
    public String toFileString() {
        return category() + ";" + articleNumber + ";" + title + ";" + price + ";" + description;

    }

    
    @Override
    public String toString() {
        return "Produktkategori: " + category() +
                ", Artikelnummer: " + getArticleNumber() +
                ", Titel: " + getTitle() +
                ", Pris: " + getPrice() +
                ", Beskrivning: " + getDescription();
    }
}
