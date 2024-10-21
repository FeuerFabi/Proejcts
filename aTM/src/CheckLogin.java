public class CheckLogin extends Login {

    private String email, password, checkEmail, checkPassword;
    private String[] displayText;

    CheckLogin(String[] displayText, String email, String password) {
        super();
        this.displayText = displayText;
        this.email = email;
        this.password = password;
    }


    public void checkLogin() {
        System.out.println(displayText[6]);
        System.out.println(displayText[0]);
        checkEmail = scanner.nextLine();
        boolean check = checkEmail(checkEmail);

        while (!check) {
            System.out.println(displayText[2]);
            System.out.println(displayText[0]);
            checkEmail = scanner.nextLine();
            check = checkEmail(checkEmail);
        }

        System.out.println(displayText[3]);
        checkPassword = scanner.nextLine();
        boolean checkPass = checkPass(checkPassword);

        while (!checkPass) {
            System.out.println(displayText[4]);
            System.out.println(displayText[3]);
            checkPassword = scanner.nextLine();
            checkPass = checkPass(checkPassword);
        }

        System.out.println(displayText[7]);
    }

    private boolean checkEmail(String email){
        return this.email.equals(email);
    }

    private boolean checkPass(String password){
        return this.password.equals(password);
    }

}
