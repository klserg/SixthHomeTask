package com.mycompany.myapp;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myMap = new MyHashMap<>();

        myMap.put(20, "hello1");
        myMap.put(12, "hello2");
        myMap.put(5, "hello3");
        myMap.put(8, "hello4");
        myMap.put(20, "hello5");
        myMap.put(5, "hello6");
        myMap.put(4, "hello7");

        System.out.println("\n"+ myMap.get(12));

        System.out.println(myMap.containsKey(3));
        System.out.println(myMap.containsKey(4));
        System.out.println();

        System.out.println("\n"+ myMap.keySet());
    }
}
