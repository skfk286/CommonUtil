package com.ycjung.lambda.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionMain {

    public static void main(String[] args) {
        // 생성자 참조
        // new는 생성자를 호출하는 키워드. Member의 생성자를 호출
        Function<String, Member> function1 = Member::new;
        //Function<String, Member> function1 = e -> new Member(e); // 위 코드와 동일 e의 동일성 제거
        Member member1 = function1.apply("java8");
        member1.printStatus();

        // 생성자 참조
        // new는 생성자를 호출하는 키워드. Member의 생성자를 호출
        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("홍길동", "java8");
        member2.printStatus();
    }
}
