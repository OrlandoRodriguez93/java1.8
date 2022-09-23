package com.mycompany.demo.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsVsStreams2 {

    public static void main(String[] args) {

        List<Integer> names = new ArrayList<>();
        names.add(2);
        names.add(0);
        names.add(10000);
        names.add(-1);
        names.add(-1);
        names.add(2);
        System.out.println(names);

        Iterator<Integer> namesIterator = names.iterator();

        while (namesIterator.hasNext()) {
            Integer i = namesIterator.next();
            System.out.println(i);
            if (i < 10000) {
                if (i == -1) {
                    System.out.println("Es un -1:" + i);
                } else if (i == 0) {
                    System.out.println("Es un 0:" + i);
                } else {
                    System.out.println("Es positivo:" + i);
                }
                namesIterator.remove();
            }
        }
        System.out.println(names);

    }
}
