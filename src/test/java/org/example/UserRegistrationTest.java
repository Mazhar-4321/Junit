package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    @Test
    public void givenFirstName_WhenWithLowercaseChars_ShouldReturnFalse() {
    UserManager userManager = new UserManager();
    boolean result=userManager.validateName("mazhar");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenWithLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        boolean result=userManager.validateName("Ma");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenWithOnlySpecialChars_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        boolean result=userManager.validateName("@_-$");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenWithAllUppercaseCharsButLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        boolean result=userManager.validateName("MA");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenWithAllCharacterCombinationsButLengthLessThan3_ShouldReturnFalse() {
        UserManager userManager = new UserManager();
        boolean result=userManager.validateName("MA");
        boolean result1=userManager.validateName("Ma");
        boolean result2=userManager.validateName("ma");
        boolean result3=userManager.validateName("M@");
        boolean result4=userManager.validateName("m@");
        boolean result5=userManager.validateName("@@");
        boolean result6=userManager.validateName("@A");
        boolean result7=userManager.validateName("@a");
        result=result||result1||result2||result3||result4||result5||result6||result7;
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenFirstName_WhenStartWithUppercaseCharAndFollowedByAnyCombinationOfOtherCharsAndLengthIsMin3_ShouldReturnTrue() {
        UserManager userManager = new UserManager();
        boolean result=userManager.validateName("MAZ");
        boolean result1=userManager.validateName("Maz");
        boolean result2=userManager.validateName("MAz");
        boolean result3=userManager.validateName("MaZ");
        boolean result4=userManager.validateName("MA@");
        boolean result5=userManager.validateName("M@A");
        boolean result6=userManager.validateName("M@@");
        boolean result7=userManager.validateName("Ma@");
        boolean result8=userManager.validateName("M@a");
        result=result&result1&result2&result3&result4&result5&result6&result7&result8;
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenMobileNumber_WhenStartWithCountryCodeOtherThan91_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validateMobileNumber("81 8125629427");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenMobileNumber_WhenStartWith91FollowedBySpaceAndFollowedByZeroAnd9Digits_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validateMobileNumber("81 0125629427");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenMobileNumber_WhenContainCharsOtherThanNumbers_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validateMobileNumber("81 91256a9b27");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenMobileNumber_WhenStartsWith91AndSpaceAnd10Numbers_ShouldReturnTrue(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validateMobileNumber("91 8125629427");
        Assert.assertEquals(true,result);
    }
    @Test
    public void givenPassword_WhenPossessLengthLessThan8_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validatePassword("abcdefg");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneUpperCaseCharacter_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validatePassword("abcd@fgh");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneNumber_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validatePassword("Abcd@fgh");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenPassword_WhenPossessLength8AndDoesntContainAtleastOneSpecialChar_ShouldReturnFalse(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validatePassword("Mazhar12345");
        Assert.assertEquals(false,result);
    }
    @Test
    public void givenPassword_WhenPossessLength8AndContainsAtleastOneSpecialCharAtleastOneNumberAndStartsWithUppercase_ShouldReturnTrue(){
        UserManager userManager = new UserManager();
        boolean result=userManager.validatePassword("Mazhar@12345");
        Assert.assertEquals(true,result);
    }

}
