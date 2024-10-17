import java.util.ArrayList;
import java.util.Scanner;

public class Login extends Konto
{
    private final String[] displayText = {
            "email: ",  // 0
            "email (Keine Whitespaces und muss '@' haben): ", // 1
            "Falsche Email!", // 2
            "passwort: ", // 3
            "Falsches Passwort!", // 4
            "Bitte registrieren!", // 5
            "Bitte anmelden!", // 6
            "Du bist nun angemeldet!" // 7
    };

    private String email;
    private String password;
    private String checkEmail;
    private String checkPassword;

    Login() {
        super();
    }

    Scanner scanner = new Scanner(System.in);

    public void registrierung() {
        System.out.println(displayText[5]);
        do {
        System.out.println(displayText[1]);
        email = scanner.nextLine();
        } while (email.isEmpty() || !email.contains("@"));
        System.out.println(displayText[3]);
        password = scanner.nextLine();
    }

    private boolean checkEmail(String email){
         return this.email.equals(email);
    }

    private boolean checkPass(String password){
        return this.password.equals(password);
    }

    public void anmelden() {
        System.out.println(displayText[6]);
        System.out.println(displayText[0]);
        checkEmail = scanner.nextLine();
        boolean check = checkEmail(checkEmail);

        while (check == false) {
            System.out.println(displayText[2]);
            System.out.println(displayText[0]);
            checkEmail = scanner.nextLine();
            check = checkEmail(checkEmail);
        }

        System.out.println(displayText[3]);
        checkPassword = scanner.nextLine();
        boolean checkPass = checkPass(checkPassword);

        while (checkPass == false) {
            System.out.println(displayText[4]);
            System.out.println(displayText[3]);
            checkPassword = scanner.nextLine();
            checkPass = checkPass(checkPassword);
        }

        System.out.println(displayText[7]);
    }
}
