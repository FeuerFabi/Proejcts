import java.util.Scanner;

public class Einzahlen implements EinsatzInterface, TextInterface {

    public int einsatz;
    public String user_input;

    Scanner input = new Scanner(System.in);

    @Override
    public void spielEinsatz() {
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
}
