package ru.dolya.solve.it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> listResult = new ArrayList<>();

        for (int num : nums2) {
            Integer currNum = map.get(num);
            if (currNum == null || currNum == 0) {
                continue;
            }
            listResult.add(num);
            map.put(num, currNum - 1);
        }

        return listResult.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
