package org.example;

public class Patterns {
    public static String emailPattern="^(([a-zA-z]{3,}(([.+-@]?[0-9_+-]{1,})|([0-9_+-]*)))(\\.[a-z]{2,})?@([a-z]{2,}|[0-9]{1})\\.[a-z]{2,}(\\.[a-z]{2,})?)$";
    public static String firstNamePattern="^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}";
    public static String lastNamePattern="^[A-Z][a-zA-Z0-9[^a-zA-Z0-9]]{2,}";
    public static String mobileNumberPattern="^(91 [1-9][0-9]{9})$";
    public static String passwordPattern="((?=.*[0-9])(?=.*[A-Z])(?=.{8,}$).*)(^([a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*)$)";


}
