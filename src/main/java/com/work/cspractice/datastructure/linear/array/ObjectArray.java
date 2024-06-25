package com.work.cspractice.datastructure.linear.array;

public class ObjectArray {
    public void solution() {
        myObject[] arrObj = new myObject[3];
        arrObj[0] = new myObject(101, "first");
        arrObj[1] = new myObject(102, "second");
        arrObj[2] = new myObject(103, "third");

        myObject[] arrObj2 = {
                new myObject(101,"obj2 first"),
                new myObject(102,"obj2 second"),
                new myObject(103,"obj2 third")
        };

        System.out.println(arrObj[0].description);
        System.out.println(arrObj2[2].description);
    }

    public static void main(String[] args) {
        ObjectArray test = new ObjectArray();
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
