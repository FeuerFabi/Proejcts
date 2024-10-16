import java.util.Scanner;

/* aTM-Machine by Fabi */
public class Main {
    public static void main(String[] args) {

        String bargeld;
        String input;
        int kontostand = 0;

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
    }
}
