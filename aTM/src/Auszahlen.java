public class Auszahlen extends AutomatenLoop implements AuszahlenInterface {

    @Override
    public void auszahlenAutomat() {
        if (Konto.kontostand != 0) {
            System.out.println(displayText[2]);
            int bargeldInput = scanner.nextInt();
            switch (bargeldInput) {
                case 1 -> {
                    bargeld = 10;
                }
                case 2 -> {
                    bargeld = 20;
                }
                case 3 -> {
                    bargeld = 50;
                }
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
        }
    }
}
