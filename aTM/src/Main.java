/* Bankautomat by Fabi */

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.registrierung();
        login.anmelden();
        AutomatenLoop automatenLoop = new AutomatenLoop();
        automatenLoop.automatenLoop();
    }
}
