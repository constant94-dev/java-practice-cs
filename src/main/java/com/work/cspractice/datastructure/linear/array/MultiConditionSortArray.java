package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;
import java.util.Comparator;

public class MultiConditionSortArray {
    /** 객체의 여러 속성을 이용해 정렬하기 위해 Comparator
     * comparing() thenComparing() 메서드를 이용해 체이닝하여 구현
     * 이때 객체 속성을 가져오기 위해 getter/setter 가 필요 */
    public void solution() {
        User[] users = {
                new User(10,"홍길동"),
                new User(20,"김씨네쌀"),
                new User(30,"신사임당"),
                new User(30,"퇴계이황"),
                new User(30,"율곡이이"),
                new User(40,"이씨네쌀"),
                new User(50,"박씨네쌀")
        };

        System.out.println("---나이순 정렬---");
        Arrays.sort(users, Comparator.comparing(User::getAge)); // 나이순 정렬
        for (User u : users) System.out.println(u.name + " " + u.age + "세");

        System.out.println("---이름순 정렬---");
        Arrays.sort(users, Comparator.comparing(User::getName)); // 이름순 정렬
        for (User u : users) System.out.println(u.name + " " + u.age + "세");

        System.out.println("---나이순 후 이름순 정렬---");
        Arrays.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName)); // 먼저 나이순 정렬 후 나이가 같으면 같은 나이만 이름순 정렬
        for (User u : users) System.out.println(u.name + " " + u.age + "세");
    }

    static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        MultiConditionSortArray test = new MultiConditionSortArray();
        test.solution();;
    }
}
