package com.ycjung.parallel;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorePerformance {

    private static final Logger log = LoggerFactory.getLogger(CorePerformance.class);

    public static void main(String[] args) {
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
}
