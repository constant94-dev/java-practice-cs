package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ObjectSortArray {
    // 객체 배열을 정렬하기 위해서는 Comparable 인터페이스, Comparator 인터페이스 지식이 필요함
    public void solution() {
        User[] users = {
                new User(10, "홍길동"),
                new User(20, "김씨네쌀"),
                new User(30, "이씨네쌀"),
                new User(40, "박씨네쌀"),
        };

        Arrays.sort(users); // 나이순 정렬
        System.out.println("---오름차순---");
        for (User u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }

        Arrays.sort(users, Collections.reverseOrder());// 나이 역순 정렬
        System.out.println("---내림차순---");
        for (User u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }
    }

    /** Comparator 인터페이스 구현해서 compare() 메서드 사용
     * Arrays.sort 배열 정렬 구현시 파라미터 값으로 Comparator 만 제공됨
     * Comparator vs Comparable 모두 사용해 본 결과
     * 상황에 따라 다르겠지만 Comparator 인터페이스 구현을 통한 정렬이 더 직관적이고 효과적으로 생각됨
     * */
    public void solution2() {
        User[] users = {
                new User(10,"홍길동"),
                new User(20,"김씨네쌀"),
                new User(30,"이씨네쌀"),
                new User(40,"박씨네쌀")
        };

        // 익명 객체를 이용해 유기적으로 다양한 속성을 받아 정렬 가능
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u1.age, u2.age); // Integer 클래스에 정의된 compare 메서드로 두 원시 정수 값 비교
            }
        });
        System.out.println("---Comparator 인터페이스 익명 함수 사용---");
        for (User u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }

        // java8 람다 표현으로 축약 가능
        Arrays.sort(users, (u1, u2) -> Integer.compare(u1.age, u2.age));
        System.out.println("---Comparator 인터페이스 람다 사용---");
        for (User u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }
    }

    // 나이순 정렬이 아닌 이름순 정렬시 compare() 메서드 대신 compareTo() 메서드로 가능
    public void solution3() {
        User[] users = {
                new User(10, "홍길동"),
                new User(20, "김씨네쌀"),
                new User(30, "이씨네쌀"),
                new User(40, "박씨네쌀"),
        };

        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        });
        System.out.println("---이름순 정렬 익명 함수 사용---");
        for (User u: users) {
            System.out.println(u.name + " " + u.age + "세");
        }

        Arrays.sort(users, (u1, u2) -> u1.name.compareTo(u2.name));
        System.out.println("---이름순 정렬 람다 사용");
        for (User u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }
    }

    public static void main(String[] args) {
        ObjectSortArray test = new ObjectSortArray();
        test.solution3();
    }

    /** 같은 타입의 인스턴스 비교할 때 Comparable 인터페이스 구현해서 compareTo() 메서드를 오버라이드해서 사용
     * Primitive type, Wrapper Class, String, Time, Date 같은 클래스 모두 정렬 가능
     * Boolean 불가능
     * */
    static class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User user) {
            // 간단한 비교 로직
            if (this.age < user.age) {
                return -1;
            } else if (this.age == user.age) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
