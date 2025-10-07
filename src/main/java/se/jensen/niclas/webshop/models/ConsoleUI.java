package se.jensen.niclas.webshop.models;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void info(String message) {
        System.out.println(message);

    }

    @Override
    public int menu() {
        System.out.println("Välkommen till min webshop");
        System.out.println("Välj ett alternativ");
        System.out.println("**************************************************");
        System.out.println("1. Lägg till en produkt i webbshopen");
        System.out.println("2. Lista alla produkter ");
        System.out.println("3. Sök efter en produkt");
        System.out.println("4. Avsluta");

        return Integer.parseInt(scanner.nextLine());
    }


}
