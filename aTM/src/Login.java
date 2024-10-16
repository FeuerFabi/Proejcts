import java.util.Scanner;

public class Login extends Konto
{
    private String email;
    private String password;
    private String checkEmail;
    private String checkPassword;

    Login() {

    }

    Scanner scanner = new Scanner(System.in);

    public Login(String email, String password) {
        super(email, password);
    }

    public void registrierung() {
        do {
        System.out.println("email (Keine Whitespaces und muss '@' haben): ");
        email = scanner.nextLine();
        } while (email.isEmpty() || !email.contains("@"));
        System.out.println("password: ");
        password = scanner.nextLine();
    }

    public boolean checkEmail(String email){
         return this.email.equals(email);
    }

    public boolean checkPass(String password){
        return this.password.equals(password);
    }

    public void anmelden() {
        System.out.println("Anmelden!");
        System.out.println("email: ");
        checkEmail = scanner.nextLine();
        boolean check = checkEmail(checkEmail);

        while (check == false) {
            System.out.println("Falsche Email!");
            System.out.println("email: ");
            checkEmail = scanner.nextLine();
            check = checkEmail(checkEmail);
        }

        System.out.println("password: ");
        checkPassword = scanner.nextLine();
        boolean checkPass = checkPass(checkPassword);

        while (checkPass == false) {
            System.out.println("Falsches Passwort!");
            System.out.println("passwort: ");
            checkPassword = scanner.nextLine();
            checkPass = checkPass(checkPassword);
        }

        System.out.println("Du bist nun angemeldet!");
    }
}

/*
 System.out.println("Bitte anmelden!");

        while (checkMail == false) {
            System.out.println("Falsche Email!");
            System.out.println("email: ");
            String ccEmail = scanner.nextLine();
            checkMail = checkLogin.checkEmail(ccEmail);
        }

        System.out.println("password: ");
        String cPassword = scanner.nextLine();
        boolean checkPassword = checkLogin.checkPass(cPassword);

        while (checkPassword == false) {
            System.out.println("Falsches Passwort!");
            System.out.println("password: ");
            String ccPassword = scanner.nextLine();
            checkPassword = checkLogin.checkPass(ccPassword);
        }
 */
