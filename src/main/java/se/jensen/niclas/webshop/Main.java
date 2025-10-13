package se.jensen.niclas.webshop;

import se.jensen.niclas.webshop.controller.ProductMenu;
import se.jensen.niclas.webshop.dao.ProductDAO;
import se.jensen.niclas.webshop.view.ConsoleUI;
import se.jensen.niclas.webshop.view.UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Skapar objekt
        Scanner scanner = new Scanner(System.in);
        UI ui = new ConsoleUI(scanner);
        ProductDAO dao = new ProductDAO();

        // Skapar menyn med produkter
        ProductMenu productmenu = new ProductMenu(dao.loadProducts(), ui, dao);


        productmenu.showMenu();


        scanner.close();
    }
}
