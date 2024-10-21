public class CheckLogin extends Login {

    private String email, password;
    private String[] displayText;

    public CheckLogin(String[] displayText, String email, String password) {
        super();
        this.displayText = displayText;
        this.email = email;
        this.password = password;
    }

    public CheckLogin() {

    }

    public void checkLogin() {
        CheckEmail checkEmail = new CheckEmail(email, displayText);
        checkEmail.checkEmail();
        CheckPassword checkPassword = new CheckPassword(password, displayText);
        checkPassword.checkPassword();
    }

}
