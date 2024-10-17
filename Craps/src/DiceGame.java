import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    private String[] displayText = {
            "Wilkommen zu Craps!\n" +
                    "Die Spielregeln lauten wie folgt, es werden zwei Würfel geworfen\n" +
                    "und du musst die beiden gewürfelten Zahlen in der Summe erraten!", // 0
            "Wähle nun deinen folgenden Einsatz -> 1e, 2e, 4e, 8e, 16e", // 1
            "Fehler beim lesen des Spielwertes %s!", // 2
            "Dein GEWINN von %d wird nun ausgezahlt!", // 3
            "Nun entscheide dich für eine magische Summe! (min 2 max 12)", // 4
            "Leider ist deine summe %d falsch, der Würfel gewinnt mit %d! ", // 5
            "Viel erfolg beim nächsten mal!", // 6
            "Glückwunsch! Du hast mit %d genau das schwarze getroffen! ", // 7
            "Dein GEWINN beträgt %d! Willst du weiter machen oder auszahlen -> w (weiter) a (auszahlen)", //8

    };
    private int einsatz = 0;
    private boolean cont = false;
    private String einsatz_input;
    private String summe;

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    private int dice1 = random.nextInt(6) + 1;
    private int dice2 = random.nextInt(6) + 1;
    private int dice_sum = dice1 + dice2;

    public void einsatz() {
        System.out.println(displayText[0]);
        System.out.println(displayText[1]);
        einsatz_input = input.nextLine();

        if (!einsatz_input.equals("1") && !einsatz_input.equals("2") && !einsatz_input.equals("4") && !einsatz_input.equals("8") && !einsatz_input.equals("16")) {
            System.out.printf(displayText[2], einsatz_input);
            System.exit(1);
        } else {
            einsatz = Integer.parseInt(einsatz_input);
        }
    }

    private void auszahlen() {
        if (einsatz != 0) {
            System.out.printf(displayText[3], einsatz);
        } else {
            System.exit(1);
        }
        input.close();
    }

    public void gameLoop() {
        do{
            System.out.println(displayText[4]);
            summe = input.nextLine();
            int user_summe = Integer.parseInt(summe);
            if (user_summe != dice_sum) {
                System.out.printf(displayText[5], user_summe, dice_sum);
                System.out.println(displayText[6]);
                einsatz = 0;
                cont = false;
            } else {
                System.out.printf(displayText[7], user_summe);
                System.out.printf(displayText[8], einsatz  *= 6);
                String userCont = input.nextLine();
                if(userCont.equals("w")) {
                    cont = true;
                } else {
                    cont = false;
                }

            }

        } while (cont == true);

        auszahlen();
    }

}
