import java.util.Scanner;

import static java.lang.Math.random;

/*
    Author: Fabi
 */
public class Main {
    public static void main(String[] args) {
        int einsatz;
        boolean cont = false;

        System.out.println("""
                Kopf oder Zahl? welcher Wert führt dich zu deinem Gewinn?
                Finde es jetzt heraus indem du Coinflip spielst!
                (min einzahlung 50c max 4e)
                """);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Wähle nun deinen Einsatz -> 50c, 1e, 2e, 4e");
        String user_input = input.nextLine();
        
        if (!user_input.equals("50") && !user_input.equals("1") && !user_input.equals("2") && !user_input.equals("4")) {
            System.err.println("Fehler beim lesen des Einsatz!");
            System.exit(1);
        }
        
        einsatz = Integer.parseInt(user_input);
        
        do {
            
            System.out.printf("Dein Einsatz von %d kann nun verdoppelt werden! ", einsatz);
            System.out.println("Kopf oder Zahl was wird es nun werden! Entscheide dich JETZT für eine Seite -> Kopf ODER Zahl");
            String head_or_num = input.nextLine();
            
            if (random() > 0.5) {
                if (head_or_num.equals("Kopf")) {
                    
                    System.out.println("Glückwunsch! Es ist Kopf! dein einsatz hat sich nun verdoppelt!");
                    System.out.printf("Dein neues Guthaben beträgt %d! ", einsatz *= 2);
                    System.out.println("Möchtest du weiter dein Glück versuchen oder Auszahlen -> w (weiter), a (auszahlen)");
                    
                    String input_cont = input.nextLine();
                    
                    if (input_cont.equals("w")) {
                        cont = true;
                    }
                    else {
                        cont = false;
                    }
                } else if (head_or_num.equals("Zahl")) {
                    
                    System.out.printf("Schade! Es ist Kopf! viel Erfolg beim nächsten mal! dein neues Guthaben beträgt %d!", einsatz = 0);
                    System.exit(1);
                    
                } else {
                    
                    System.err.println("Fehler beim lesen des Spielwertes!");
                    System.exit(1);
                    
                }
            } else {
                if (head_or_num.equals("Kopf")) {
                    
                    System.out.printf("Schade! Es ist Zahl! viel Erfolg beim nächsten mal! dein neues Guthaben beträgt %d!", einsatz = 0);
                    
                } else if (head_or_num.equals("Zahl")) {
                    
                    System.out.println("Glückwunsch! Es ist zahl! dein einsatz hat sich nun verdoppelt!");
                    System.out.printf("Dein neues Guthaben beträgt %d! ", einsatz *= 2);
                    System.out.println("Möchtest du weiter dein Glück versuchen oder Auszahlen -> w (weiter), a (auszahlen)");
                    
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
        if (einsatz != 0) {
            
            System.out.printf("Dein GEWINN von %d wird nun ausgezahlt! Bis zur nächsten Partie Coinflip!", einsatz);
            
        }
        else {
            System.exit(1);
        }
        input.close();
    }
}
