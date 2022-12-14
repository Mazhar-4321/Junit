package org.example;

public class UserManager {

    public String validateLastName(String name) {
        try {
            if (!name.matches("^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}")) {
                throw new InvalidUserDetailsException("Invalid Last Name");
            }
        } catch (InvalidUserDetailsException invalidUserDetailsException) {
            return invalidUserDetailsException.getMessage();
        }
        return "Last Name Registered Successfully";
    }

    public String validateFirstName(String name) {
        try {
            if (!name.matches("^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}")) {
                throw new InvalidUserDetailsException("Invalid First Name");
            }
        } catch (InvalidUserDetailsException invalidUserDetailsException) {
            return invalidUserDetailsException.getMessage();
        }
        return "First Name Registered Successfully";
    }

    public String validateMobileNumber(String mobileNumber) {
        try {
            if (!mobileNumber.matches("^(91 [1-9][0-9]{9})$")) {
                throw new InvalidUserDetailsException("Invalid Mobile Number");
            }
        } catch (InvalidUserDetailsException invalidUserDetailsException) {
            return invalidUserDetailsException.getMessage();
        }
        return "Mobile Number Registered Successfully";
    }

    public String validatePassword(String password) {
        try {
            if (!password.matches("((?=.*[0-9])(?=.*[A-Z])(?=.{8,}$).*)(^([a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*)$)")) {
                throw new InvalidUserDetailsException("Invalid Password");
            }
        } catch (InvalidUserDetailsException invalidUserDetailsException) {
            System.out.println(invalidUserDetailsException.getMessage());
            return invalidUserDetailsException.getMessage();
        }
        return "Password Registered Successfully";
    }

    public String validateEmail(String email) {
        String pattern = "^(([a-zA-z]{3,}(([.+-@]?[0-9_+-]{1,})|([0-9_+-]*)))(\\.[a-z]{2,})?@([a-z]{2,}|[0-9]{1})\\.[a-z]{2,}(\\.[a-z]{2,})?)$";
        try {
            if (!email.matches(pattern)) {
                throw new InvalidUserDetailsException("Invalid Email");
            }
        } catch (InvalidUserDetailsException invalidUserDetailsException) {
            return invalidUserDetailsException.getMessage();
        }
        return "Email Registered Successfully";
    }
}
