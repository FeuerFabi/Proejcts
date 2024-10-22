import java.util.Scanner;

import static java.lang.Math.random;

public class GameLoop implements GameLoopInterface, TextInterface {

    private boolean cont = false;


    @Override
    public void gameLoop() {
        int gewinn;
        Einzahlen einzahlen = new Einzahlen();
        Auszahlen auszahlen = new Auszahlen();
        Scanner input = new Scanner(System.in);
            do {
                if (einzahlen.einsatz == 0) {
                    einzahlen.spielEinsatz();
                }
                System.out.printf(displayText[4], einzahlen.einsatz);
                System.out.println(displayText[5]);
                String head_or_num = input.nextLine();
                if (random() > 0.5) {
                    if (head_or_num.equals("Kopf")) {
                        System.out.println(displayText[6]);
                        gewinn = einzahlen.einsatz *= 2;
                        System.out.printf(displayText[7], einzahlen.einsatz );
                        System.out.println(displayText[8]);
                        String input_cont = input.nextLine();
                        if (input_cont.equals("w")) {
                            cont = true;
                        }
                        else {
                            einzahlen.einsatz += gewinn;
                            auszahlen.spielAuszahlung(einzahlen.einsatz);
                            cont = false;
                        }
                    } else if (head_or_num.equals("Zahl")) {
                        System.out.printf(displayText[9], einzahlen.einsatz = 0);
                        System.exit(1);
                    } else {
                        System.err.println(displayText[10]);
                        System.exit(1);
                    }
                } else {
                    if (head_or_num.equals("Kopf")) {
                        System.out.printf(displayText[11], einzahlen.einsatz = 0);
                        System.exit(1);
                    } else if (head_or_num.equals("Zahl")) {
                        System.out.println(displayText[12]);
                        gewinn = einzahlen.einsatz *= 2;
                        System.out.printf(displayText[13], einzahlen.einsatz);
                        System.out.println(displayText[8]);
                        String input_cont = input.nextLine();
                        if (input_cont.equals("w")) {
                            cont = true;
                        }
                        else {
                            einzahlen.einsatz += gewinn;
                            auszahlen.spielAuszahlung(einzahlen.einsatz);
                            cont = false;
                        }
                    }
                }
            } while (cont == true);
        }
    }
