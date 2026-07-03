package ru.dolya.solve.it;

import java.util.Locale;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : charArray) {
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                stringBuilder.append(c);
            }
        }


        String string = stringBuilder.toString();
        if (string.length() == 1) {
            return false;
        }
        String rString = stringBuilder.reverse().toString();

        return string.equals(rString);
    }
}
