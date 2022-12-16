package org.example;

import java.util.function.Consumer;

@FunctionalInterface
public interface IValidation {
    static String print(String s, IValidation function, String successMessage, String failureMessage) {
        try {
            if (!function.validate(s)) {
                throw new InvalidUserDetailsException(failureMessage);
            }
        } catch (InvalidUserDetailsException e) {
            return e.getMessage();
        }
        return successMessage;
    }

    public boolean validate(String s) throws InvalidUserDetailsException;
}
