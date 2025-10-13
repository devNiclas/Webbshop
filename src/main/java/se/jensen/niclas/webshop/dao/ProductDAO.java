package se.jensen.niclas.webshop.dao;

import se.jensen.niclas.webshop.Product;
import se.jensen.niclas.webshop.models.Accessories;
import se.jensen.niclas.webshop.models.Clothing;
import se.jensen.niclas.webshop.models.Shoes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    // Atribut
    private Path file = Path.of("data/products.txt");

    // Kolla om katalogen finns, annars skapa en
    private void checkIfDirectoryExists() throws IOException {
        Path parent = file.getParent();
        if (parent != null && Files.notExists(parent)) {
            Files.createDirectories(parent);
        }
    }

    public void saveProducts(List<Product> products) throws IOException {
        checkIfDirectoryExists();

        List<String> lines = new ArrayList<>();

        for (Product product : products) {
            lines.add(product.toFileString());
        }
        Files.write(file, lines);
        // Sparar produkter, skriver över existerande innehåll

    }

    public List<Product> loadProducts() {
        // Lagra objekt från Product
        List<Product> products = new ArrayList<>();
        if (Files.exists(file)) {
            try {
                List<String> lines = Files.readAllLines(file);
                for (String line : lines) {
                    products.add(ProductDAO.fromFileString(line));
                }
            } catch (IOException e) {
                System.out.println("Fel vid inläsning av produkter");
            }
        }
        return products;
    }
    // Läser produkter från fil, skapar objekt


    public static Product fromFileString(String line) {
        String[] parts = line.split(";", 5);
        String type = parts[0]; // Kategori
        String articleNumber = parts[1];
        String title = parts[2];
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];

        return switch (type.trim()) {
            case "Kläder" -> new Clothing(articleNumber, title, price, description);
            case "Skor" -> new Shoes(articleNumber, title, price, description);
            case "Accessoarer" -> new Accessories(articleNumber, title, price, description);
            default -> throw new IllegalArgumentException("Okänd produktkategori " + type);
        };
    }
}
// Konverterar en rad från fil till produkt
// Om kategori inte finns kasta exception
