package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EmailTest {
    private static String expectedResultEmailSuccess = "Email Registered Successfully";
    private static String expectedResultEmailFailure = "Invalid Email";
    private String email;
    private String expectedResult;
    private UserManager userManager;
    private String expectedResultFirstNameSuccess = "First Name Registered Successfully";
    private String expectedResultFirstNameFailure = "Invalid First Name";
    private String expectedResultLastNameSuccess = "Last Name Registered Successfully";
    private String expectedResultLastNameFailure = "Invalid Last Name";
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
        return Arrays.asList(new Object[][]{{"abc@yahoo.com", expectedResultEmailSuccess}, {"abc-100@yahoo.com", expectedResultEmailSuccess},
                {"abc.100@yahoo.com", expectedResultEmailSuccess}, {"abc111@abc.com", expectedResultEmailSuccess}, {"abc-100@abc.net", expectedResultEmailSuccess},
                {"abc.100@abc.com.au", expectedResultEmailSuccess}, {"abc@1.com", expectedResultEmailSuccess}, {"abc@gmail.com.com", expectedResultEmailSuccess},
                {"abc+100@gmail.com", expectedResultEmailSuccess}, {"abc", expectedResultEmailFailure}, {"abc@.com.my", expectedResultEmailFailure}, {"abc123@gmail.a", expectedResultEmailFailure},
                {"abc123@.com", expectedResultEmailFailure}, {"abc123@.com.com", expectedResultEmailFailure}, {".abc@abc.com", expectedResultEmailFailure},
                {"abc()*@gmail.com", expectedResultEmailFailure}, {"abc@%*.com", expectedResultEmailFailure},
                {"abc..2002@gmail.com", expectedResultEmailFailure}, {"abc@abc@gmail.com", expectedResultEmailFailure}, {"abc.@gmail.com", expectedResultEmailFailure},
                {"abc@gmail.com.1a", expectedResultEmailFailure}, {"abc@gmail.com.aa.au", expectedResultEmailFailure}});
    }

    @Before
    public void initialize() {
        userManager = new UserManager();
    }

    @Test
    public void EmailTest() {
        String observedResult= userManager.validateEmail(email);
        Assert.assertSame(expectedResult, observedResult);
    }

    @Test
    public void givenFirstName_WhenWithLowercaseChars_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("mazhar");
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("Ma");
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithOnlySpecialChars_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("@_-$");
        Assert.assertEquals((Object)expectedResultFirstNameFailure,(Object) result);
    }

    @Test
    public void givenFirstName_WhenWithAllUppercaseCharsButLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("MA");
        Assert.assertEquals(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenWithAllCharacterCombinationsButLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("MA");
        String result1 = userManager.validateFirstName("Ma");
        String result2 = userManager.validateFirstName("ma");
        String result3 = userManager.validateFirstName("M@");
        String result4 = userManager.validateFirstName("m@");
        String result5 = userManager.validateFirstName("@@");
        String result6 = userManager.validateFirstName("@A");
        String result7 = userManager.validateFirstName("@a");
        result=result.equals(expectedResultFirstNameFailure)|result1.equals(expectedResultFirstNameFailure)|
                result2.equals(expectedResultFirstNameFailure)|result3.equals(expectedResultFirstNameFailure)|
                result4.equals(expectedResultFirstNameFailure)|result5.equals(expectedResultFirstNameFailure)|
                result6.equals(expectedResultFirstNameFailure)|result7.equals(expectedResultFirstNameFailure)?expectedResultFirstNameFailure:expectedResultFirstNameSuccess;
          Assert.assertSame(expectedResultFirstNameFailure, result);
    }

    @Test
    public void givenFirstName_WhenStartWithUppercaseCharAndFollowedByAnyCombinationOfOtherCharsAndLengthIsMin3_ShouldReturnTrue() {
        UserManager userManager = new UserManager();
        String result = userManager.validateFirstName("MAZ");
        String result1 = userManager.validateFirstName("Maz");
        String result2 = userManager.validateFirstName("MAz");
        String result3 = userManager.validateFirstName("MaZ");
        String result4 = userManager.validateFirstName("MA@");
        String result5 = userManager.validateFirstName("M@A");
        String result6 = userManager.validateFirstName("M@@");
        String result7 = userManager.validateFirstName("Ma@");
        String result8 = userManager.validateFirstName("M@a");
        result=result.equals(expectedResultFirstNameSuccess)&result1.equals(expectedResultFirstNameSuccess)&
                result2.equals(expectedResultFirstNameSuccess)&result3.equals(expectedResultFirstNameSuccess)&
                result4.equals(expectedResultFirstNameSuccess)&result5.equals(expectedResultFirstNameSuccess)&
                result6.equals(expectedResultFirstNameSuccess)&result7.equals(expectedResultFirstNameSuccess)&
                result8.equals(expectedResultFirstNameSuccess)?expectedResultFirstNameSuccess:expectedResultFirstNameFailure;
        Assert.assertEquals(expectedResultFirstNameSuccess, result);
    }

    @Test
    public void givenMobileNumber_WhenStartWithCountryCodeOtherThan91_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateMobileNumber("81 8125629427");
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenStartWith91FollowedBySpaceAndFollowedByZeroAnd9Digits_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateMobileNumber("81 0125629427");
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenContainCharsOtherThanNumbers_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validateMobileNumber("81 91256a9b27");
        Assert.assertEquals(expectedResultMobileNumberFailure, result);
    }

    @Test
    public void givenMobileNumber_WhenStartsWith91AndSpaceAnd10Numbers_ShouldReturnTrue() {
        UserManager userManager = new UserManager();
        String result = userManager.validateMobileNumber("91 8125629427");
        Assert.assertEquals(expectedResultMobileNumberSuccess, result);
    }

    @Test
    public void givenPassword_WhenPossessLengthLessThan8_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validatePassword("abcdefg");
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneUpperCaseCharacter_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validatePassword("abcd@fgh");
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneNumber_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        String result = userManager.validatePassword("Abcd@fgh");
        Assert.assertEquals(expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneSpecialChar_ShouldReturnFalse() {
            UserManager userManager = new UserManager();
            String result = userManager.validatePassword("Mazhar12345");
            Assert.assertEquals( expectedResultPasswordFailure, result);
    }

    @Test
    public void givenPassword_WhenPossessLength8AndContainsAtleastOneSpecialCharAtleastOneNumberAndStartsWithUppercase_ShouldReturnTrue() {
        UserManager userManager = new UserManager();
        String result = userManager.validatePassword("Mazhar@12345");
        Assert.assertEquals(expectedResultPasswordSuccess, result);
    }


}
