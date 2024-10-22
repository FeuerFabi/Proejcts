public class Auszahlen implements AuszahlenInterface, TextInterface {

    @Override
    public int spielAuszahlung(int einsatzLoop) {
        if (einsatzLoop != 0) {
            System.out.printf(displayText[3],einsatzLoop);
        }
        else {
            System.exit(1);
        }
        return 0;
    }
}

