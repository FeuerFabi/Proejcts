import java.util.Scanner;

public class Login extends Konto implements LoginInterface {

    private String email, password;

    Login() {
        super();
    }

    Scanner scanner = new Scanner(System.in);

    @Override public void registrierung() {
        Registrierung register = new Registrierung(LoginInterface.displayText);
        register.registrieren();
        this.email = register.email;
        this.password = register.password;
    }



    @Override public void anmelden() {
        CheckLogin checkLogin = new CheckLogin(LoginInterface.displayText, this.email, this.password);
        checkLogin.checkLogin();
    }
}
