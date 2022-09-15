package com.ycjung.lambda.function;

import java.util.function.ToIntBiFunction;

/**
 * Function: 매개값, 리턴값 모두 있음(주로 매개값은 리턴값으로 매핑)
 *   Function<T, R>
 *   T는 입력 타입
 *   R은 출력 타입 (Apply의 return 타입)
 */
public class ToIntBiFunctionMain {

    public static void main(String[] args) {
        ToIntBiFunction<String, String> function;

        function = (a, b) -> a.compareToIgnoreCase(b);
        print(function.applyAsInt("Hello World", "hello world"));

        function = String::compareToIgnoreCase;
        print(function.applyAsInt("Hello World", "hello world"));
    }

    public static void print(int order){
        if(order == 0) {
            System.out.println("동일한 문자열입니다.");
        }
    }
}
