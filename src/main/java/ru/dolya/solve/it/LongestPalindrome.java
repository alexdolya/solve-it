package ru.dolya.solve.it;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result += entry.getValue() / 2;
        }
        result = result * 2;
        if (result < s.length()) {
            result++;
        }
        return result;
    }
}
