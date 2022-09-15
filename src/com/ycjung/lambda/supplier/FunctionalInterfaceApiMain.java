package com.ycjung.lambda.supplier;

import java.util.function.IntSupplier;

/**
 * Supplier: 매개값이 없고 리턴값이 있음
 */
public class FunctionalInterfaceApiMain {

    public static void main(String[] args) {
        IntSupplier intSupplier = () ->{
            int num = (int)(Math.random()*6) +1;
            return num;
        };
        int num = intSupplier.getAsInt();
        System.out.println("주사위 눈: "+ num);
    }
}
