package se.jensen.niclas.webshop.models;

public interface UI {
    public String prompt(String message);

    public void info(String message);

    public int menu();
}
