
import java.util.Random;
import java.util.Scanner;


/*
    Author: Fabi
 */

public class Main {
    public static void main(String[] args) {
        int einsatz = 0;
        boolean cont = false;

        System.out.println("""
                Wilkommen zu Craps! Ein beliebtes amerikianisches Würfelspiel!
                Die Spielregeln lauten wie folgt, es werden zwei Würfel geworfen
                und du musst die beiden gewürfelten Zahlen in der Summe erraten!
                """);

        Scanner input = new Scanner(System.in);
        System.out.println("Wähle nun deinen folgenden Einsatz -> 1e, 2e, 4e, 8e, 16e");
        String einsatz_input = input.nextLine();

        if (!einsatz_input.equals("1") && !einsatz_input.equals("2") && !einsatz_input.equals("4") && !einsatz_input.equals("8") && !einsatz_input.equals("16")) {
            System.out.printf("Fehler beim lesen des Spielwertes %s!", einsatz_input);
            System.exit(1);
        } else {
            einsatz = Integer.parseInt(einsatz_input);
        }

        Random random = new Random();
        do{
            int würfel1 = random.nextInt(6) + 1;
            int würfel2 = random.nextInt(6) + 1;
            int dice_res = würfel1 + würfel2;

            System.out.println("Nun entscheide dich für eine magische Summe! (min 2 max 12)");
            String summe = input.nextLine();
            int user_summe = Integer.parseInt(summe);
            if (user_summe != dice_res) {
                System.out.printf("Leider ist deine summe %d falsch, der Würfel gewinnt mit %d! ", user_summe, dice_res);
                System.out.println("Viel erfolg beim nächsten mal!");
                einsatz = 0;
                cont = false;
            } else {
                System.out.printf("Glückwunsch! Du hast mit %d genau das schwarze getroffen! ", user_summe);
                System.out.printf("Dein GEWINN beträgt %d! Willst du weiter machen oder auszahlen -> w (weiter) a (auszahlen)", einsatz  *= 6);
                String userCont = input.nextLine();
                if(userCont.equals("w")) {
                    cont = true;
                } else {
                    cont = false;
                }

            }

        } while (cont == true);

        if (einsatz != 0) {
            System.out.printf("Dein GEWINN von %d wird nun ausgezahlt!", einsatz);
        } else {
            System.exit(1);
        }
        input.close();

    }


}