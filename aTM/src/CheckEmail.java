public class CheckEmail extends CheckLogin {
    private String email, checkEmail;
    private String[] displayText;

    CheckEmail(String email, String[] displayText) {
        this.email = email;
        this.displayText = displayText;
    }

    public void checkEmail() {
        System.out.println(displayText[6]);
        System.out.println(displayText[0]);
        checkEmail = scanner.nextLine();
        boolean check = this.email.equals(checkEmail);

        while (!check) {
            System.out.println(displayText[2]);
            System.out.println(displayText[0]);
            checkEmail = scanner.nextLine();
            check = this.email.equals(checkEmail);
        }
    }

}
