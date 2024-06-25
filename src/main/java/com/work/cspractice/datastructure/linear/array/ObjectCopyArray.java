package com.work.cspractice.datastructure.linear.array;

import java.util.Arrays;

public class ObjectCopyArray {
    public void solution() {
        myObject[] arrObj = {
                new myObject(101,"first"),
                new myObject(102,"second"),
                new myObject(103,"third")
        };
        System.out.println(Arrays.toString(arrObj)); // 배열에 담긴 값의 객체 주소

        myObject[] arrObj2;
        arrObj2 = arrObj.clone();
        System.out.println(Arrays.toString(arrObj2)); // 배열에 담긴 값의 객체 주소 똑같다

        System.out.println(arrObj[0].id);
        System.out.println(arrObj2[0].id);

        arrObj[0].id = 999; // arrObj 첫번째 객체 id 변경

        // 같은 주소이기 때문에 함께 변경
        System.out.println(arrObj[0].id); // 999
        System.out.println(arrObj2[0].id); // 999

        // 따라서 깊은 복사를 해야함 (다른 주소를 가지게 함)
        myObject[] arrObj3 = new myObject[3];
        for (int i = 0; i < arrObj.length; i++) {
            arrObj3[i] = new myObject(arrObj[i].id, arrObj[i].description);
        }
        System.out.println(Arrays.toString(arrObj3)); // 배열에 담긴 값의 객체 주소가 달라짐

        System.out.println(arrObj[0].id);

        arrObj[0].id = 888;

        // 다른 주소이기 때문에 함께 변경 안됨
        System.out.println(arrObj[0].id); // 888
        System.out.println(arrObj3[0].id); // 999
    }

    public static void main(String[] args) {
        ObjectCopyArray test = new ObjectCopyArray();
        test.solution();
    }

    static class myObject {
        int id;
        String description;

        public myObject(int id, String description) {
            this.id = id;
            this.description = description;
        }
    }
}
