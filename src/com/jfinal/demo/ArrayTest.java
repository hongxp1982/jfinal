package com.jfinal.demo;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ArrayTest {

    public static void main(String[] args) {
        // Child[] cs = new Child[] { new Child(), new Child() };
        // Person[] persons = cs;
        //
        // persons[0] = new Person();向下转型,既父类型转成子类型

		/*Person[] pp = new Child[] {};
        List<String> l = new MyArrayList();
		Object[] objs = l.toArray();
		System.err.println(objs.getClass());
		objs[0] = new Object();

		List<Integer> list2 = new MyArrayList(list);
		System.err.println(list2.size());
		*/

        List<String> list = new ArrayList(16);
        for (int i = 0; i < 10; i++)
            list.add(UUID.randomUUID().toString().replaceAll("-", ""));

        for (int i = 0; i < list.size(); i++)
            System.err.println(list.get(i));

        String randomString = list.get(2);

        Collections.sort(list);
        System.err.println(" ");

        for (int i = 0; i < list.size(); i++)
            System.err.println(list.get(i));

        int index = Collections.binarySearch(list, randomString);
        System.err.println("current index is :" + index);

    }

    static class Person {

    }

    static class Child extends Person {

    }

    static class MyArrayList extends ArrayList {
        @Override
        public String[] toArray() {
            return new String[]{"a", "b"};
        }

        public MyArrayList() {
            // TODO Auto-generated constructor stub
        }

        public MyArrayList(Collection c) {
            super(c);
        }

        public MyArrayList(int initialCapacity) {
            super(initialCapacity);
        }

    }
}
