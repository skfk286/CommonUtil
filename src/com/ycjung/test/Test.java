package com.ycjung.test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        list.stream().forEach(System.out::println);

        System.out.println("Optional.ofNullable(list) : " + Optional.ofNullable(list));
    }
}
