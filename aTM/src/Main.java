import java.util.Scanner;

/* Bankautomat by Fabi */

public class Main {
    public static void main(String[] args) {
        
        Login login = new Login();
        login.registrierung();
        login.anmelden();
        Konto konto = new Konto();
        konto.automatenLoop();
    }
}
