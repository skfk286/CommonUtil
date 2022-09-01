package com.ycjung.test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello JavaWorld!!");

        System.out.println("Input Number :");
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        for(int i=1; i<=9; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
    }
}
