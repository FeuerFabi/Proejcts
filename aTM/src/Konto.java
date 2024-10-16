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
