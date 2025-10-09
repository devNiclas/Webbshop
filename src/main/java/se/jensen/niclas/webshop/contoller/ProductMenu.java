package se.jensen.niclas.webshop.contoller;

import se.jensen.niclas.webshop.Product;
import se.jensen.niclas.webshop.dao.ProductDAO;
import se.jensen.niclas.webshop.models.Accessories;
import se.jensen.niclas.webshop.models.Clothing;
import se.jensen.niclas.webshop.models.Shoes;
import se.jensen.niclas.webshop.models.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductMenu {
    private List<Product> products = new ArrayList<>();
    private final UI ui;
    private ProductDAO dao;
//    private Scanner scanner = new Scanner(System.in);


    public ProductMenu(List<Product> products, UI ui, ProductDAO dao) {
        this.products = products;
        this.ui = ui;
        this.dao = dao;

    }

    public void addProduct(Product p) {
        products.add(p);

    }

    public void showMenu() {
        boolean running = true;
        while (running) {

            int choice = ui.menu();


            switch (choice) {
                case 1:
                    try {
                        Product p = askForProduct();
                        products.add(p);
                        dao.saveProducts(products);
                        ui.info("Produkten har lagts till och sparats");
                    } catch (IllegalArgumentException e) {
                        ui.info(e.getMessage());
                    } catch (IOException e) {
                        ui.info("Kunde inte spara produkten till filen");
                    }
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    ui.info("Du avslutade applikationen");
                    running = false;
                default:
                    ui.info("Ogitlgit menyval, försök igen!");


            }
        }
    }

    public void listProducts() {
        if (products.isEmpty()) {
            ui.info("Finns inga produkter i webbshopen");
        } else {
            for (Product product : products) {
                ui.info(product.toString());
            }
        }
        ui.info("**************************************************");
        ui.prompt("Tryck enter för att komma tillbaka till menyn");
    }

    public void searchProduct() {
        String searchArticle = ui.prompt("Mata in artikelnummer");
        boolean found = false;

        for (Product product : products) {
            if (product.getArticleNumber().equals(searchArticle)) {
                ui.info("Produkt hittad" + product);
                found = true;
                break;
            }
        }
        if (!found) {
            ui.info("Inga produkter med det artikelnumret finns i webbshopen");
        }

    }


    public Product askForProduct() {
        int option = ui.productOptions();
        ui.info("Vänligen skriv in:");
        String articleNumber = ui.prompt("Artikelnummer:");
        String title = ui.prompt("Titel:");
        double price = Double.parseDouble(ui.prompt("Pris:"));
        String description = ui.prompt("Beskrivning:");

        return switch (option) {
            case 1 -> new Clothing(articleNumber, title, price, description);
            case 2 -> new Shoes(articleNumber, title, price, description);
            case 3 -> new Accessories(articleNumber, title, price, description);
            default -> throw new IllegalArgumentException("Ogiltigt produktval " + option);
        };


    }


}






