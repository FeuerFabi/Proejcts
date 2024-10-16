import java.util.Scanner;

public class Konto {
    
    private final String[] displayText = {
            "Nicht genug geld auf dem Konto! du hast %d EURO und hast versucht %d EURO abzubuchen!", // 0
            "Drück 1 zum auszahlen, 2 zum einzahlen, 3 um Kontostand anzuzeigen, 4 zum abbrechen", // 1
            "Drücke 1 für 10 EURO, 2 für 20 EURO, 3 für 50 EURO, 4 für anderer Betrag", // 2
            "Bitte gewünschten Betrag eingeben: ", // 3
            "Bitte eine Zahl von 1 - 4 eingeben!", // 4
            "Du hast erfolgreich %d EURO abgehoben!", // 5
            "Bitte Betrag eingeben! ", // 6
            "Folgender Betrag wird auf dein konto gebucht %d EURO!", // 7
            "Dein Kontostand beträgt %d EURO!", // 8
            "Fehler! Bitte eine 1, 2, 4 oder 4 eingeben" //9

    };

    private int input;
    private int kontostand = 0;
    private int bargeld = 0;

    Scanner scanner = new Scanner(System.in);

    public Konto() {

    }

    public int einzahlen(int bargeld) {
        return kontostand += bargeld;
    }

    public int auszahlen(int bargeld) {
        kontostand -= bargeld;
        return bargeld;
    }

    public int kontostand() {
        return kontostand;
    }

    public String display(String input) {
        return input;
    }

    public void inputGroesserAlsKontostand(int barInput, int kontostand) {
        if (barInput > kontostand) {
            System.out.printf(displayText[0], kontostand, barInput);
            System.exit(1);
        }
    }

    public void automatenLoop() {
        do {
            System.out.println(displayText[1]);
            input = scanner.nextInt();

            switch (input) {
                case 1 -> {
                    if (kontostand() != 0) {
                        System.out.println(displayText[2]);
                        int bargeldInput = scanner.nextInt();
                        switch (bargeldInput) {
                            case 1 -> {bargeld = 10;}
                            case 2 -> {bargeld = 20;}
                            case 3 -> {bargeld = 50;}
                            case 4 -> {
                                System.out.println(displayText[3]);
                                bargeldInput = scanner.nextInt();
                                inputGroesserAlsKontostand(bargeldInput, kontostand());
                                bargeld = bargeldInput;
                            }
                            default -> {
                                System.out.println(displayText[4]);
                                scanner.close();
                                System.exit(1);
                            }
                        }
                        int a = auszahlen(bargeld);
                        System.out.println(display(displayText[5].formatted(a)));
                        break;
                    }

                }
                case 2 -> {
                    System.out.println(displayText[6]);
                    int bargeld = scanner.nextInt();
                    einzahlen(bargeld);
                    System.out.println(display(displayText[7].formatted(bargeld)));
                    break;
                }
                case 3 -> {
                    int k = kontostand();
                    System.out.println(display(displayText[8].formatted(k)));
                    break;
                }
                case 4 -> {
                    System.exit(1);
                }
                default -> {
                    System.out.println(displayText[9]);
                }
            }

        } while (input != 4);
    }
}
