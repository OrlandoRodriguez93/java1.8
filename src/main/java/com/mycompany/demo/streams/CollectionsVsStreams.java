package com.mycompany.demo.streams;

import java.util.ArrayList;
import java.util.List;

public class CollectionsVsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        names.remove(0);

        // List<String> names2 = new ArrayList<>();

        // for (int i = 0; i < names2.size(); i++) {
        // System.out.println(i);
        // names2.remove(i);
        // }

        System.out.println(names);

        for (String name : names) {
            System.out.println(name);
        }

        names.stream().forEach(System.out::println);

    }
}
