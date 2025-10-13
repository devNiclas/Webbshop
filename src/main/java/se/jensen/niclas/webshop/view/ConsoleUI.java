package se.jensen.niclas.webshop.view;

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
        while (true) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║    Välkommen till min Webshop    ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║       Välj ett alternativ        ║");
            System.out.println("║                                  ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println(" 1. ➕  Lägg till en produkt     ");
            System.out.println(" 2. ⭐ Lista alla produkter           ");
            System.out.println(" 3. \uD83D\uDD0D Sök efter en produkt           ");
            System.out.println(" 4. ❌ Avsluta                        ");
            System.out.println("╚══════════════════════════════════╝");

            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.println("Välj ett alternativ mellan 1-4");
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen");
            }


        }
    }


    @Override
    public int productOptions() {
        while (true) {
            System.out.println("Vilken typ av produkt vill du lägga till?");
            System.out.println("1.👕 Kläder | 2. 👟 Skor | 3. 🧢 Accessoarer");
            System.out.println("\n⬆\uFE0F Välj ett alternativ");

            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
                System.out.println("Mata in ett nummer mellan 1-3");
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen");
            }

        }


    }
}
