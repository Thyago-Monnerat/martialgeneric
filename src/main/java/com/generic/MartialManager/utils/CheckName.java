package com.generic.MartialManager.utils;

import com.generic.MartialManager.Exceptions.InvalidNameFormatException;

public class CheckName {
    public static boolean nameValidator(String name) {
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (!Character.isLetter(currentChar)) {
                throw new InvalidNameFormatException("Formato do nome inválido!");
            }
        }

        return false;
    }
}
