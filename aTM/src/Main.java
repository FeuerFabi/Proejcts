import java.util.Scanner;

/* Bankautomat by Fabi */

public class Main {
    public static void main(String[] args) {
        
        int input;
        Scanner scanner= new Scanner(System.in);
        Login login = new Login();
        login.registrierung();
        login.anmelden();
        
        Konto konto = new Konto();
        int bar = 0;
        do {
            System.out.println("Drück 1 zum auszahlen, 2 zum einzahlen, 3 um Kontostand anzuzeigen, 4 zum abbrechen");
            input = scanner.nextInt();

            switch (input) {
                case 1 -> {
                    if (konto.kontostand() != 0) {
                        System.out.println("Drücke 1 für 10 EURO, 2 für 20 EURO, 3 für 50 EURO, 4 für anderer Betrag");
                        int bargeldInput = scanner.nextInt();
                        switch (bargeldInput) {
                            case 1 -> {bar = 10;}
                            case 2 -> {bar = 20;}
                            case 3 -> {bar = 50;}
                            case 4 -> {
                                System.out.println("Bitte gewünschten Betrag eingeben: ");
                                bargeldInput = scanner.nextInt();
                                konto.inputGroesserAlsKontostand(bargeldInput, konto.kontostand());
                                bar = bargeldInput;
                            }
                            default -> {
                                System.out.println("Bitte eine Zahl von 1 - 4 eingeben!");
                                scanner.close();
                                System.exit(1);
                            }
                        }
                        int a = konto.auszahlen(bar);
                        System.out.println(konto.display("Du hast erfolgreich %d EURO abgehoben!".formatted(a)));
                        break;
                    }

                }
                case 2 -> {
                    System.out.println("Bitte Betrag eingeben! ");
                    int bargeld = scanner.nextInt();
                    konto.einzahlen(bargeld);
                    System.out.println(konto.display("Folgender Betrag wird auf dein konto gebucht %d EURO!".formatted(bargeld)));
                    break;
                }
                case 3 -> {
                    int k = konto.kontostand();
                    System.out.println(konto.display("Dein Kontostand beträgt %d EURO!".formatted(k)));
                    break;
                }
                case 4 -> {
                    System.exit(1);
                }
                default -> {
                    System.out.println("Fehler! Bitte eine 1, 2, 4 oder 4 eingeben");
                }
            }

        } while (input != 4);
    }
}
