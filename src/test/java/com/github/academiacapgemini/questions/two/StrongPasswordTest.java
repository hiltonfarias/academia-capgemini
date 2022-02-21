package com.github.academiacapgemini.questions.two;

import com.github.academiacapgemini.questions.exceptions.DigitNotFoundException;
import com.github.academiacapgemini.questions.exceptions.InvalidCharacterNumberException;
import com.github.academiacapgemini.questions.exceptions.LowercaseLetterNotFoundException;
import com.github.academiacapgemini.questions.exceptions.SpecialCharacterNotFoundException;
import com.github.academiacapgemini.questions.exceptions.UppercaseLetterNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrongPasswordTest {

    private StrongPassword two;
    private static final StringBuilder PASSWORD_VALID = new StringBuilder("As1&qw");
    private static final StringBuilder PASSWORD_INVALID = new StringBuilder("......||||");

    @BeforeEach
    void before() {
        this.two = new StrongPassword();
    }

    @AfterEach
    void after() {
        this.two = new StrongPassword();
    }

    @Test
    void mustHaveAValidSize() {
        StringBuilder passwordRef = new StringBuilder();
        passwordRef.append("As1&qw");

        two.setPassword(PASSWORD_VALID);

        Assertions.assertArrayEquals(passwordRef.toString().toCharArray(), two.getPassword().toString().toCharArray());
    }

    @Test
    void mustHaveAnInvalidSize() {
        two.setPassword(new StringBuilder("As&1"));
        Assertions.assertThrows(InvalidCharacterNumberException.class, two::checkNumberOfCharacters);
    }

    @Test
    void mustHaveAtLeastOneDigit() throws Exception {
        two.setPassword(PASSWORD_VALID);
        Assertions.assertEquals(1, two.digitWasFound());
    }

    @Test
    void noDigitsFound() {
        two.setPassword(PASSWORD_INVALID);
        Assertions.assertThrows(DigitNotFoundException.class, two::digitWasFound);
    }

    @Test
    void mustContainAtLeastOneLowercaseLetter() throws Exception {
        two.setPassword(PASSWORD_VALID);
        Assertions.assertEquals('s', two.lowercaseWasFound());
    }

    @Test
    void lowercaseLetterNotFound() {
        two.setPassword(PASSWORD_INVALID);
        Assertions.assertThrows(LowercaseLetterNotFoundException.class, two::lowercaseWasFound);
    }

    @Test
    void mustContainAtLeastOneUppercaseLetter() throws Exception {
        two.setPassword(PASSWORD_VALID);
        Assertions.assertEquals('A', two.uppercaseWasFound());
    }

    @Test
    void uppercaseLetterNotFound() {
        two.setPassword(PASSWORD_INVALID);
        Assertions.assertThrows(UppercaseLetterNotFoundException.class, two::uppercaseWasFound);
    }

    @Test
    void mustContainAtLeastOneSpecialCharacter() throws Exception {
        two.setPassword(PASSWORD_VALID);
        Assertions.assertEquals('&', two.specialCharacterWasFound());
    }

    @Test
    void specialCharacterNotFound() {
        two.setPassword(PASSWORD_INVALID);
        Assertions.assertThrows(SpecialCharacterNotFoundException.class, two::specialCharacterWasFound);
    }

}