import java.util.Scanner;

import static java.lang.Math.random;

public class CoinGame {
    private final String[] displayText = {
            "Kopf oder Zahl? welcher Wert führt dich zu deinem Gewinn?\n" +
                    "Finde es jetzt heraus indem du Coinflip spielst!\n" +
                    "(min einzahlung 50c max 4e)", // 0
            "Wähle nun deinen Einsatz -> 50c, 1e, 2e, 4e", // 1
            "Fehler beim lesen des Einsatz!", // 2
            "Dein GEWINN von %d wird nun ausgezahlt! Bis zur nächsten Partie Coinflip!", // 3
            "Dein Einsatz von %d kann nun verdoppelt werden! ", // 4
            "Kopf oder Zahl was wird es nun werden! Entscheide dich JETZT für eine Seite -> Kopf ODER Zahl", // 5
            "Glückwunsch! Es ist Kopf! dein einsatz hat sich nun verdoppelt!", // 6
            "Dein neues Guthaben beträgt %d! ", // 7
            "Möchtest du weiter dein Glück versuchen oder Auszahlen -> w (weiter), a (auszahlen)", // 8
            "Schade! Es ist Kopf! viel Erfolg beim nächsten mal! dein neues Guthaben beträgt %d!", // 9
            "Fehler beim lesen des Spielwertes!", // 10
            "Schade! Es ist Zahl! viel Erfolg beim nächsten mal! dein neues Guthaben beträgt %d!", // 11
            "Glückwunsch! Es ist zahl! dein einsatz hat sich nun verdoppelt!", // 12
            "Dein neues Guthaben beträgt %d! ", // 13
            "Möchtest du weiter dein Glück versuchen oder Auszahlen -> w (weiter), a (auszahlen)", // 14
    };
    private String user_input;
    private int einsatz;
    private boolean cont = false;

    Scanner input = new Scanner(System.in);

    public void einsatz() {
        System.out.println(displayText[0]);
        System.out.println(displayText[1]);
        user_input = input.nextLine();
        if (!user_input.equals("50") && !user_input.equals("1") && !user_input.equals("2") && !user_input.equals("4")) {
            System.err.println(displayText[2]);
            System.exit(1);
        } else {
            einsatz = Integer.parseInt(user_input);
        }
    }

    private void auszahlen(String user_input) {
        einsatz = Integer.parseInt(user_input);

        if (einsatz != 0) {
            System.out.printf(displayText[3], einsatz);
        }
        else {
            System.exit(1);
        }
        input.close();
    }

    public void gameLoop() {
        do {
            System.out.printf(displayText[4], einsatz);
            System.out.println(displayText[5]);
            String head_or_num = input.nextLine();
            if (random() > 0.5) {
                if (head_or_num.equals("Kopf")) {
                    System.out.println(displayText[6]);
                    System.out.printf(displayText[7], einsatz *= 2);
                    System.out.println(displayText[8]);
                    String input_cont = input.nextLine();
                    if (input_cont.equals("w")) {
                        cont = true;
                    }
                    else {
                        cont = false;
                    }
                } else if (head_or_num.equals("Zahl")) {
                    System.out.printf(displayText[9], einsatz = 0);
                    System.exit(1);
                } else {
                    System.err.println(displayText[10]);
                    System.exit(1);
                }
            } else {
                if (head_or_num.equals("Kopf")) {
                    System.out.printf(displayText[11], einsatz = 0);
                    System.exit(1);
                } else if (head_or_num.equals("Zahl")) {
                    System.out.println(displayText[12]);
                    System.out.printf(displayText[13], einsatz *= 2);
                    System.out.println(displayText[14]);
                    String input_cont = input.nextLine();
                    if (input_cont.equals("w")) {
                        cont = true;
                    }
                    else {
                        cont = false;
                    }
                }
            }
        } while (cont == true);
        auszahlen(user_input);
    }
}
