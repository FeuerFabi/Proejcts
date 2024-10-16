public class Konto {
    public String email;
    public String password;
    private int kontostand = 0;
    private int bargeld = 0;

    public Konto() {

    }
   public Konto(String email, String password) {
        this.email = email;
        this.password = password;
   }
    /*
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

     */

    public int einzahlen(int bargeld) {
        return kontostand += bargeld;
    }

    public int auszahlen(int bargeld) {
        kontostand -= bargeld;
        return bargeld;
    }

    public int kontostand() {
        return kontostand;
    }

    public String display(String input) {
        return input;
    }
}
