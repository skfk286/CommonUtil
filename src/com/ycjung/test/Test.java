package com.ycjung.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        list.stream().forEach(System.out::println);

    }
}
