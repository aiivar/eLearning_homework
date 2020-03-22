package ru.kpfu.itis.j903.cw.minsafin.inf_7;

import ru.kpfu.itis.j903.cw.minsafin.inf_6.MyMap;
import ru.kpfu.itis.j903.cw.minsafin.inf_6.setformap.FromArrayListSet;
import ru.kpfu.itis.j903.cw.minsafin.inf_7.tech.Topic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamApiHomework {

    public static void execute() {
        Comparator<Topic> comparator = (Topic o1, Topic o2) -> o1.getViews() - o2.getViews(); //Homework 7.4
        Topic a = new Topic(32, "abd");
        Topic b = new Topic(321, "sdads");
        System.out.println(comparator.compare(a, b));
        List<Integer> list = new ArrayList<>(); //Homework 7.5
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 23; i++) {
            list2.add(i);
        }
        int list2max = list2.stream().max((o1, o2) -> o1 - o2).get();
        List<Integer> newList = list.stream().filter((e) -> e.compareTo(list2max) > 0).collect(Collectors.toList());
        System.out.println(newList);
        Set<String> set = new FromArrayListSet<String>(); //Homework 7.6
        set.add("abcdefgeeeuuu");
        set.add("abcdefgeeuu");
        set.add("abcdefgeeyauuu");
        set.add("abcdefgeeoeuuu");
        set.add("ddddddd");
        set.add("mmmmmmm");
        set.add("aaa");
        long strsCount = set.stream().filter((String str) -> {
            String vowels = "aoeyiu";
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < vowels.length(); j++) {
                    if (str.charAt(i) == vowels.charAt(j)) {
                        count++;
                    }
                }
            }
            return count > 3;
        }).count();
        System.out.println(strsCount);
        MyMap<Integer, String> myMap = new MyMap<>(); //Homework 7.7
        for (int i = 0; i < 5; i++) {
            myMap.put(i, "value" + i);
        }
        String concatenatedKeys = myMap.keySet().stream().map(integer -> integer.toString()).collect(Collectors.joining());
        System.out.println(concatenatedKeys);
        List<String> strings = new ArrayList<String>(); // Homework 7.8
        for (int i = 2; i < 12; i++) {
            String add = "";
            for (int j = 0; j < i; j++) {
                add = add.concat(String.valueOf(j));
            }
            strings.add(add);
        }
        int lenghtSum = strings.stream().filter(str -> str.length() > 5).mapToInt(str -> str.length()).sum();
        System.out.println(lenghtSum);
    }
}
