import java.util.Scanner;

/* Bankautomat by Fabi */

public class Main {
    public static void main(String[] args) {

        // Registrierung
        int input;
        String userEmail;
        String userPassword;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte registriere dich! ");

        do {
        System.out.println("email (Keine Whitespaces und muss '@' haben): ");
        userEmail = scanner.nextLine();
        } while (userEmail.isEmpty() || !userEmail.contains("@"));

        System.out.println("password: ");
        userPassword = scanner.nextLine();

        // Anmeldung
        CheckLogin checkLogin = new CheckLogin(userEmail, userPassword);
        // Konto konto = new Konto(email, password);

        System.out.println("Bitte anmelden!");

        System.out.println("email: ");
        String cEmail = scanner.nextLine();
        boolean checkMail = checkLogin.checkEmail(cEmail);

        while (checkMail == false) {
            System.out.println("Falsche Email!");
            System.out.println("email: ");
            String ccEmail = scanner.nextLine();
            checkMail = checkLogin.checkEmail(ccEmail);
        }

        System.out.println("password: ");
        String cPassword = scanner.nextLine();
        boolean checkPassword = checkLogin.checkPass(cPassword);

        while (checkPassword == false) {
            System.out.println("Falsches Passwort!");
            System.out.println("password: ");
            String ccPassword = scanner.nextLine();
            checkPassword = checkLogin.checkPass(ccPassword);
        }

        System.out.println("Du bist nun angemeldet!");
        
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
                            case 1 -> {
                                if (bargeldInput > konto.kontostand()) {
                                    System.out.printf("Nicht genug geld auf dem Konto! du hast %d EURO und hast versucht %d EURO abzubuchen!", konto.kontostand(), bargeldInput);
                                    System.exit(1);
                                }
                                bar = 10;
                            }
                            case 2 -> {
                                if (bargeldInput > konto.kontostand()) {
                                    System.out.printf("Nicht genug geld auf dem Konto! du hast %d EURO und hast versucht %d EURO abzubuchen!", konto.kontostand(), bargeldInput);
                                    System.exit(1);
                                }
                                bar = 20;
                            }
                            case 3 -> {
                                if (bargeldInput > konto.kontostand()) {
                                    System.out.printf("Nicht genug geld auf dem Konto! du hast %d EURO und hast versucht %d EURO abzubuchen!", konto.kontostand(), bargeldInput);
                                    System.exit(1);
                                }
                                bar = 50;
                            }
                            case 4 -> {
                                System.out.println("Bitte gewünschten Betrag eingeben: ");
                                bargeldInput = scanner.nextInt();
                                if (bargeldInput > konto.kontostand()) {
                                    System.out.printf("Nicht genug geld auf dem Konto! du hast %d EURO und hast versucht %d EURO abzubuchen!", konto.kontostand(), bargeldInput);
                                    System.exit(1);
                                }
                                bar = bargeldInput;
                            }
                            default -> {
                                System.out.println("Bitte eine Zahl von 1 - 4 eingeben!");
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
