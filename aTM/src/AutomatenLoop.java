public class AutomatenLoop extends Konto implements AutomatenLoopInterface {
    private int input;

    public void auszahlen(AuszahlenInterface obj) {
        obj.auszahlenAutomat();
    }

   @Override
     public void automatenLoop() {
        Auszahlen auszahlen = new Auszahlen();
        do {
            System.out.println(displayText[1]);
            input = scanner.nextInt();
            switch (input) {
                case 1 -> {auszahlen.auszahlenAutomat();}
                case 2 -> {
                    System.out.println(displayText[6]);
                    int bargeld = scanner.nextInt();
                    einzahlen(bargeld);
                    System.out.println(display(displayText[7].formatted(bargeld)));
                }
                case 3 -> {System.out.println(display(displayText[8].formatted(kontostand())));}
                case 4 -> {System.exit(1);}
                default -> {System.out.println(displayText[9]);}
            }
        } while (input != 4) ;
    }

}
