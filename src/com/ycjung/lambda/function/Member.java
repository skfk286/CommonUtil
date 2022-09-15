package com.ycjung.lambda.function;

public class Member {

    private String name = "아무개";
    private String id = "없다";

    public Member() {
        System.out.println("Member() 실행");
    }

    public Member(String id) {
        System.out.println("Member(String id) 실행");
        this.id = id;
    }

    public Member(String name, String id) {
        System.out.println("Member(String name, String id) 실행");
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void printStatus() {
        System.out.println("name: " + name);
        System.out.println("id: " + id);
    }
}
