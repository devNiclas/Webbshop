package se.jensen.niclas.webshop.view;

public interface UI {
    public String prompt(String message);

    public void info(String message);

    public int menu();

    public int productOptions();

}
