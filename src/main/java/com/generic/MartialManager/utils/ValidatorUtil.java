package com.generic.MartialManager.utils;

import com.generic.MartialManager.exceptions.InvalidNameFormatException;

public class ValidatorUtil {
    public static void hasEspecialChar(String name) {
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (!Character.isLetter(currentChar) && !Character.isSpaceChar(currentChar)) {
                throw new InvalidNameFormatException("Formato do nome inválido!");
            }
        }
    }
}
