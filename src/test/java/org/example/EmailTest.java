package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class EmailTest {
    private static String expectedResultEmailSuccess = "Email Registered Successfully";
    private static String expectedResultEmailFailure = "Invalid Email";
    private IValidation emailValidation = (p) -> p.matches(Patterns.emailPattern);
    private IValidation firstNameValidation = (p) -> p.matches(Patterns.firstNamePattern);
    private IValidation mobileNumberValidation = (p) -> p.matches(Patterns.mobileNumberPattern);
    private IValidation passwordValidation = (p) -> p.matches(Patterns.passwordPattern);
    private String email;
    private String expectedResult;
    private String expectedResultFirstNameSuccess = "First Name Registered Successfully";
    private String expectedResultFirstNameFailure = "Invalid First Name";
    private String expectedResultMobileNumberSuccess = "Mobile Number Registered Successfully";
    private String expectedResultMobileNumberFailure = "Invalid Mobile Number";
    private String expectedResultPasswordSuccess = "Password Registered Successfully";
    private String expectedResultPasswordFailure = "Invalid Password";

    public EmailTest(String email, String expectedResult) {
        this.email = email;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{{"abc@yahoo.com", expectedResultEmailSuccess},
                {"abc-100@yahoo.com", expectedResultEmailSuccess},
                {"abc.100@yahoo.com", expectedResultEmailSuccess},
                {"abc111@abc.com", expectedResultEmailSuccess},
                {"abc-100@abc.net", expectedResultEmailSuccess},
                {"abc.100@abc.com.au", expectedResultEmailSuccess},
                {"abc@1.com", expectedResultEmailSuccess},
                {"abc@gmail.com.com", expectedResultEmailSuccess},
                {"abc+100@gmail.com", expectedResultEmailSuccess},
                {"abc", expectedResultEmailFailure},
                {"abc@.com.my", expectedResultEmailFailure},
                {"abc123@gmail.a", expectedResultEmailFailure},
                {"abc123@.com", expectedResultEmailFailure},
                {"abc123@.com.com", expectedResultEmailFailure},
                {".abc@abc.com", expectedResultEmailFailure},
                {"abc()*@gmail.com", expectedResultEmailFailure},
                {"abc@%*.com", expectedResultEmailFailure},
                {"abc..2002@gmail.com", expectedResultEmailFailure},
                {"abc@abc@gmail.com", expectedResultEmailFailure},
                {"abc.@gmail.com", expectedResultEmailFailure},
                {"abc@gmail.com.1a", expectedResultEmailFailure},
                {"abc@gmail.com.aa.au", expectedResultEmailFailure}});
    }


    @Test
    public void EmailTest() {
        String observedResult = IValidation.print(email, emailValidation, expectedResultEmailSuccess, expectedResultEmailFailure);
        Assert.assertSame(expectedResult, observedResult);
    }

    @Test
    public void givenFirstName_WhenWithLowercaseChars_ShouldReturnFalse() {
        String result = IValidation.print("mazhar", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithLengthLessThan3_ShouldReturnFalse() {
        String result = IValidation.print("Ma", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        ;
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithOnlySpecialChars_ShouldReturnFalse() {
        String result = IValidation.print("@_-$", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        Assert.assertEquals((Object) expectedResultFirstNameFailure, (Object) result);
    }

    @Test
    public void givenFirstName_WhenWithAllUppercaseCharsButLengthLessThan3_ShouldReturnFalse() {
        String result = IValidation.print("MA", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithAllCharacterCombinationsButLengthLessThan3_ShouldReturnFalse() {
        String result = IValidation.print("MA", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result1 = IValidation.print("Ma", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result2 = IValidation.print("ma", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result3 = IValidation.print("M@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result4 = IValidation.print("m@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result5 = IValidation.print("@@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result6 = IValidation.print("@A", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result7 = IValidation.print("@a", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        result = result.equals(expectedResultFirstNameFailure) | result1.equals(expectedResultFirstNameFailure) |
                result2.equals(expectedResultFirstNameFailure) | result3.equals(expectedResultFirstNameFailure) |
                result4.equals(expectedResultFirstNameFailure) | result5.equals(expectedResultFirstNameFailure) |
                result6.equals(expectedResultFirstNameFailure) | result7.equals(expectedResultFirstNameFailure) ? expectedResultFirstNameFailure : expectedResultFirstNameSuccess;
        Assert.assertSame(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenStartWithUppercaseCharAndFollowedByAnyCombinationOfOtherCharsAndLengthIsMin3_ShouldReturnTrue() {
        String result = IValidation.print("MAZ", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result1 = IValidation.print("Maz", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result2 = IValidation.print("MAz", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result3 = IValidation.print("MaZ", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result4 = IValidation.print("MA@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result5 = IValidation.print("M@A", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result6 = IValidation.print("M@@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result7 = IValidation.print("Ma@", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        String result8 = IValidation.print("M@a", firstNameValidation, expectedResultFirstNameSuccess, expectedResultFirstNameFailure);
        result = result.equals(expectedResultFirstNameSuccess) & result1.equals(expectedResultFirstNameSuccess) &
                result2.equals(expectedResultFirstNameSuccess) & result3.equals(expectedResultFirstNameSuccess) &
                result4.equals(expectedResultFirstNameSuccess) & result5.equals(expectedResultFirstNameSuccess) &
                result6.equals(expectedResultFirstNameSuccess) & result7.equals(expectedResultFirstNameSuccess) &
                result8.equals(expectedResultFirstNameSuccess) ? expectedResultFirstNameSuccess : expectedResultFirstNameFailure;
        Assert.assertEquals(expectedResultFirstNameSuccess, result);
    }

    @Test
    public void givenMobileNumber_WhenStartWithCountryCodeOtherThan91_ShouldReturnFalse() {
        String result = IValidation.print("81 8125629427", mobileNumberValidation, expectedResultMobileNumberSuccess, expectedResultMobileNumberFailure);
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenStartWith91FollowedBySpaceAndFollowedByZeroAnd9Digits_ShouldReturnFalse() {
        String result = IValidation.print("81 0125629427", mobileNumberValidation, expectedResultMobileNumberSuccess, expectedResultMobileNumberFailure);
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenContainCharsOtherThanNumbers_ShouldReturnFalse() {
        String result = IValidation.print("81 91256a9b27", mobileNumberValidation, expectedResultMobileNumberSuccess, expectedResultMobileNumberFailure);
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenStartsWith91AndSpaceAnd10Numbers_ShouldReturnTrue() {
        String result = IValidation.print("91 8125629427", mobileNumberValidation, expectedResultMobileNumberSuccess, expectedResultMobileNumberFailure);
        Assert.assertEquals(expectedResultMobileNumberSuccess, result);
    }

    @Test
    public void givenPassword_WhenPossessLengthLessThan8_ShouldReturnFalse() {
        String result = IValidation.print("abcdefg", passwordValidation, expectedResultPasswordSuccess, expectedResultPasswordFailure);
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneUpperCaseCharacter_ShouldReturnFalse() {
        String result = IValidation.print("abcd@fgh", passwordValidation, expectedResultPasswordSuccess, expectedResultPasswordFailure);
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneNumber_ShouldReturnFalse() {
        String result = IValidation.print("Abcd@fgh", passwordValidation, expectedResultPasswordSuccess, expectedResultPasswordFailure);
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneSpecialChar_ShouldReturnFalse() {
        String result = IValidation.print("Mazhar12345", passwordValidation, expectedResultPasswordSuccess, expectedResultPasswordFailure);
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndContainsAtleastOneSpecialCharAtleastOneNumberAndStartsWithUppercase_ShouldReturnTrue() {
        String result = IValidation.print("Mazhar@12345", passwordValidation, expectedResultPasswordSuccess, expectedResultPasswordFailure);
        Assert.assertEquals(expectedResultPasswordSuccess, result);
    }


}
