public class Registrierung extends Login {
    public String email, password;
    private String[] displayText;

    public Registrierung(String[] displayText) {
        this.displayText = displayText;
    }

    public void registrieren() {
        System.out.println(displayText[5]);
        do {
            System.out.println(displayText[1]);
            email = scanner.nextLine();
        } while (email.isEmpty() || !email.contains("@"));
        System.out.println(displayText[3]);
        password = scanner.nextLine();
    }

}
