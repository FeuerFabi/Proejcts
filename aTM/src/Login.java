import java.util.Scanner;

public class Login extends Konto implements LoginInterface {

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

    private String email, password;

    Login() {
        super();
    }

    Scanner scanner = new Scanner(System.in);

    @Override public void registrierung() {
        System.out.println(displayText[5]);
        do {
        System.out.println(displayText[1]);
        email = scanner.nextLine();
        } while (email.isEmpty() || !email.contains("@"));
        System.out.println(displayText[3]);
        password = scanner.nextLine();
    }



    @Override public void anmelden() {
        CheckLogin checkLogin = new CheckLogin(this.displayText, this.email, this.password);
        checkLogin.checkLogin();
    }

