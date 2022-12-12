package org.example;

public class UserManager {

    public boolean validateName(String name) {
        return name.matches("^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}");
    }

    public boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber.matches("^(91 [1-9][0-9]{9})$");
    }

    public boolean validatePassword(String password) {
        return password.matches("((?=.*[0-9])(?=.*[A-Z])(?=.{8,}$).*)(^([a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*)$)");
    }

    public boolean validateEmail(String email) {
        String pattern = "^(([a-zA-z]{3,}(([.+-@]?[0-9_+-]{1,})|([0-9_+-]*)))(\\.[a-z]{2,})?@([a-z]{2,}|[0-9]{1})\\.[a-z]{2,}(\\.[a-z]{2,})?)$";
        return email.matches(pattern);
    }
}
