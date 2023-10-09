package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();


        list.add(12);
        list.add(32);
        list.add(45);

        list.remove("taleh");

        System.out.println(list);
    }
}
