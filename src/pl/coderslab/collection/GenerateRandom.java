package pl.coderslab.collection;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {
    public static void main(String[] args) {
        System.out.println(checkRand(500000, 10));
    }

    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Random randomamount = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < interval; i++) {
            map.put(i, 0);
        }
        for (int j = 0; j < amount; j++) {
            int count = randomamount.nextInt(interval);
            map.put(count, map.get(count) + 1);
        }
        return map;
    }

}
