package com.ycjung.parallel;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorePerformance {

    private static final Logger log = LoggerFactory.getLogger(CorePerformance.class);

    /**
     * 상황 1 : 싱글 스레드
     * 1부터 16까지 총 16개의 숫자를 출력합니다.
     * 출력하기 전 스레드를 1초씩 재우고 요소를 출력하고 총 소요시간을 출력하는 코드입니다.
     *
     * 하나의 스레드가 1초씩 잠들고 출력하기 때문에, 결과값은 약16,000ms가 나와야합니다.
     */
    public static void case1() {
        System.out.println("stream (16 elements) ");

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1, 16)
        .peek(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })
        .forEach(i -> log.info("i = {}", i));
        stopWatch.stop();
        log.info(">>> stream takes [{}]ms", stopWatch.getTotalTimeMillis());
    }

    /**
     * 상황 2 : 병렬 처리
     * pc의 상황에따라 다르나. pc가 16스레드를 지원한다면,
     * 한 번에 16개의 스레드가 동시에 작업이 가능하므로 1초간 잠들고 연산을 수행합니다.
     *
     * 이론상이라면 결과 값은 약1,000ms가 나와야합니다.
     */
    public static void case2() {
        log.info("==== parallel stream (16 elements) ====");
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1, 16)
            .parallel()
            .peek(i -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })
            .forEach(i -> log.info("i = {}", i));
        stopWatch.stop();
        log.info(">>> parallel stream takes [{}]ms", stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        //case1();
        case2();
    }
}
