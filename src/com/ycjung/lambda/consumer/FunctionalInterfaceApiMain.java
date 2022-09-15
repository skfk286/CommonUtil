package com.ycjung.lambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

/**
 * Consumer: 매개값은 있고 리턴값이 없음
 */
public class FunctionalInterfaceApiMain {

    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.println(t + " Class");
        consumer.accept("Java");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t+u);
        biConsumer.accept("Java", " Class");

        DoubleConsumer doubleConsumer = d -> System.out.println(d + "를 10으로 나눈 나머지 " + d%10 + "입니다.");
        doubleConsumer.accept(14.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t+i);
        objIntConsumer.accept("Java", 8);
    }
}
