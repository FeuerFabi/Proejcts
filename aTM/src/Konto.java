import java.util.Scanner;

public class Konto implements KontoInterface {

    public static int kontostand = 0;
    public int bargeld = 0;

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

    public void getLoop(AutomatenLoopInterface obj) {
        obj.automatenLoop();
    }

    public void atmLoop(AutomatenLoop loop) {
        loop.getLoop((AutomatenLoopInterface) loop);
    }
}
