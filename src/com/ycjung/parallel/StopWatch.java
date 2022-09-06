package com.ycjung.parallel;

public class StopWatch {
    private long beforeTime;
    private long afterTime;

    public void start() {
        this.beforeTime = System.currentTimeMillis();
    }

    public void stop() {
        this.afterTime = System.currentTimeMillis();
    }

    public long getTotalTimeMillis() {
        return this.afterTime - this.beforeTime;
    }

    /**
     * 사용 예시
     * @param args
     */
    public static void main(String[] args) {
        /*
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
        */

        long beforeTime = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 50000; j++) {
                sum += i*j;
            }
        }
        System.out.println(sum);

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
