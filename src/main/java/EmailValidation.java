

public class EmailValidation {

    public boolean validateEmail(String email) {
        if (email.contains("@"))
            return true;
        else return false;
    }
}
