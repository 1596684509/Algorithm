package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class E599 {

    @Test
    public void t() {

        findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Shogun","Burger King"});

    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        if(list1.length < list2.length) {
            return findRestaurant(list2, list1);
        }

        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {

            map.put(list1[i], i);

        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {

            if(map.containsKey(list2[i])) {

                min = Math.min(min, map.get(list2[i]) + i);

            }

        }

        for (String string : map.keySet()) {
            if(min - map.get(string) >= 0 && min - map.get(string) < list2.length &&  string.equals(list2[min - map.get(string)])) {

                res.add(string);

            }
        }



        return res.toArray(new String[]{});

    }

    public String[] findRestaurantOther(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {

            map.put(list1[i], i);

        }

        for (int i = 0; i < list2.length; i++) {

            if(map.containsKey(list2[i])) {

                if(map.get(list2[i]) + i < min) {

                    strings.clear();
                    strings.add(list2[i]);
                    min = map.get(list2[i]) + i;

                }else if(map.get(list2[i]) + i == min) {

                    strings.add(list2[i]);

                }

            }

        }

        return strings.toArray(new String[]{});

    }

}
