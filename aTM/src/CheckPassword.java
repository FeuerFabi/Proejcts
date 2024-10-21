public class CheckPassword extends CheckLogin {
    private String password, checkPassword;
    private String[] displayText;

    CheckPassword(String password, String[] displayText) {
        this.password = password;
        this.displayText = displayText;
    }

    public void checkPassword() {
        System.out.println(displayText[3]);
        checkPassword = scanner.nextLine();
        boolean checkPass = this.password.equals(checkPassword);

        while (!checkPass) {
            System.out.println(displayText[4]);
            System.out.println(displayText[3]);
            checkPassword = scanner.nextLine();
            checkPass = this.password.equals(checkPassword);
        }
        System.out.println(displayText[7]);
    }
}
