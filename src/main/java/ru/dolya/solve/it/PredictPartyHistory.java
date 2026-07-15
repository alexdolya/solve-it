package ru.dolya.solve.it;

import java.util.LinkedList;
import java.util.Queue;

public class PredictPartyHistory {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR"));
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            Integer rIndex = radiant.poll();
            Integer dIndex = dire.poll();

            if (rIndex < dIndex) {
                radiant.offer(rIndex + length);
            } else {
                dire.offer(dIndex + length);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
