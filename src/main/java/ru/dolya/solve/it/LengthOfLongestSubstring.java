package ru.dolya.solve.it;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = left;

        Set<Character> set = new HashSet<>();
        char[] cArr = s.toCharArray();
        int result = 0;
        while (right < s.length()) {
            char currentChar = cArr[right];
            if (!set.contains(currentChar)) {
                set.add(currentChar);
            } else {
                result = Math.max(result, set.size());
                while (set.contains(currentChar)) {
                    set.remove(cArr[left]);
                    left++;
                }
                set.add(currentChar);
            }
            right++;
        }
        return Math.max(result, set.size());
    }
}
