package ru.dolya.solve.it;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveStars {

    public static void main(String[] args) {
        System.out.println(removeStars("prog*ram**mer"));
    }

    public static String removeStars(String s) {
        char[] arr = s.toCharArray();

        Deque<Character> stack = new LinkedList<>();

        for (char c : arr) {
            if (c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.toString();
    }
}
