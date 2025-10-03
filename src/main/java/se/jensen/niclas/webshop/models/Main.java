package se.jensen.niclas.webshop.models;

public class Main {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();

        ProductMenu productmenu = new ProductMenu(ui);


        productmenu.showMenu();
    }
}
