public class CheckLogin extends Konto
{

    public CheckLogin(String email, String password) {
        super(email, password);
    }

    public boolean checkEmail(String email){
         return this.email.equals(email);
    }

    public boolean checkPass(String password){
        return this.password.equals(password);
    }
}
