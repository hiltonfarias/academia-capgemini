package com.github.academiacapgemini.questions.two;

import com.github.academiacapgemini.questions.exceptions.DigitNotFoundException;
import com.github.academiacapgemini.questions.exceptions.InvalidCharacterNumberException;
import com.github.academiacapgemini.questions.exceptions.LowercaseLetterNotFoundException;
import com.github.academiacapgemini.questions.exceptions.SpecialCharacterNotFoundException;
import com.github.academiacapgemini.questions.exceptions.UppercaseLetterNotFoundException;

public class StrongPassword {

    private StringBuilder password;
    private int numberOfDigits;

    public StringBuilder getPassword() {
        return password;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setPassword(StringBuilder password) {
        try {
            this.password = password;
            this.checkNumberOfCharacters();
            this.digitWasFound();
            this.lowercaseWasFound();
            this.uppercaseWasFound();
            this.specialCharacterWasFound();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void checkNumberOfCharacters() throws Exception {
        if (!this.sizeIsValid(this.password.length())) {
            numberOfDigits += 6 - this.password.length();
            throw new InvalidCharacterNumberException("A senha deve conter seis ou mais caracteres!");
        }
    }

    private boolean sizeIsValid(int value) {
        return value >= 6;
    }

    public int digitWasFound() throws Exception {
        int digit = -1;
        char[] ref = "0123456789".toCharArray();
        for (char aChar : ref) {
            for (char passwordChar : this.password.toString().toCharArray()) {
                if (passwordChar == aChar) {
                    digit = Character.getNumericValue(passwordChar);
                }
            }
        }
        if (digit < 0) {
            numberOfDigits++;
            throw new DigitNotFoundException("A senha não contêm digito!");
        }
        return digit;
    }

    public Character lowercaseWasFound() throws Exception {
        char[] ref = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Character result = getCharacter(ref);
        if (result != null) return result;
        numberOfDigits++;
        throw new LowercaseLetterNotFoundException("A senha não contêm letra minúscula!");
    }

    public Character uppercaseWasFound() throws Exception {
        char[] ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Character result = getCharacter(ref);
        if (result != null) return result;
        numberOfDigits++;
        throw new UppercaseLetterNotFoundException("A senha não contêm letra maiúscula!");
    }

    public Character specialCharacterWasFound() throws Exception {
        char[] ref = "!@#$%^&*()-+".toCharArray();
        Character result = getCharacter(ref);
        if (result != null) return result;
        numberOfDigits++;
        throw new SpecialCharacterNotFoundException("A senha não contêm caractere especial!");
    }

    private Character getCharacter(char[] ref) {
        char result;
        for (char passwordChar : this.password.toString().toCharArray()) {
            for (char aChar : ref) {
                if (passwordChar == aChar) {
                    result = passwordChar;
                    return result;
                }
            }
        }
        return null;
    }
}
