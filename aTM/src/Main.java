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

        System.out.println("password (: ");
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

/*
        while (!email.contains("@")){
            System.out.println("Bitte eine gültige email angeben!");
            System.out.println("email: ");
            email = scanner.nextLine();
            if (email.contains("@")){
                break;
            }
        }
         */
        /*

        String bargeld;
        String input;
        int kontostand = 0;

        System.out.println("passwort: ");
        String passwort = scanner.nextLine();

        Konto konto = new Konto(email, passwort);
        System.out.println("Registrierung Erfolgreich!");

        System.out.println("Bitte anmelden!");
        System.out.println("email: ");
        checkEmail = scanner.nextLine();

        if (checkEmail.equals(email)){
            System.out.println("Passwort: ");
            checkPasswort = scanner.nextLine();
            if (checkPasswort.equals(passwort)){
                System.out.println("Du bist nun eingeloggt!");
            }
        } else {
            while (!checkEmail.equals(email)){
                System.out.println("Falsche Email!");
                System.out.println("email: ");
                checkEmail = scanner.nextLine();
                if (checkEmail.equals(email)){
                    System.out.println("passwort: ");
                    checkPasswort = scanner.nextLine();
                    if (checkPasswort.equals(passwort)){
                        System.out.println("Du bist nun eingelogg!");
                        break;
                    }
                }
            }
            while (!checkPasswort.equals(passwort)) {
                System.out.println("Falsche Passwort!");
                System.out.println("passwort: ");
                checkPasswort = scanner.nextLine();
            }

        do {
            System.out.println("1. Einzahlen, 2. Auszahlen, 3. Kontostand, zum Abbrechen -> 5");
            input = new Scanner(System.in).nextLine();

            if (input.equals("1")) {

                System.out.println("Bitte füge nun dein Bargeld ein!");
                bargeld = new Scanner(System.in).nextLine();

                kontostand += Integer.parseInt(bargeld);
                System.out.println("Dein neuer Kontostand beträgt nun: " + kontostand);
            } else if (input.equals("2")) {

                System.out.println("Bitte wähle deinen gewünschten Betrag aus!");
                System.out.println("10(1), 20(2), 50(3), 100(4), Anderer Betrag(5)");
                String auszahlenInput = new Scanner(System.in).nextLine();

                if (Integer.parseInt(auszahlenInput) >= kontostand) {
                    System.out.println("Sie haben nicht genug Geld um diese Operation auszuführen!");
                    continue;
                }

                switch (auszahlenInput) {
                    case "1" -> {
                        kontostand -= 10;
                        System.out.println("Dein neuer Kontostand beträgt nun " + kontostand);
                    }
                    case "2" -> {
                        kontostand -= 20;
                        System.out.println("Dein neuer Kontostand beträgt nun: " + kontostand);
                    }
                    case "3" -> {
                        kontostand -= 50;
                        System.out.println("Dein neuer Kontostand beträgt nun: " + kontostand);
                    }
                    case "4" -> {
                        kontostand -= 100;
                        System.out.println("Dein neuer Kontostand beträgt nun: " + kontostand);
                    }
                }

            } else if (input.equals("3")) {
                System.out.println("Dein Kontostand beträgt: " + kontostand);
            } else {
                if (input.equals("5")) {
                    break;
                }
                System.out.println("Bitte wähle eine Option aus dem Menü aus!");
            }
        } while (!input.equals("5"));

     */
    }
}
