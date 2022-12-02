package ru.emelyanovkonstantin;

import com.google.common.collect.ImmutableMap;

import java.util.Map;


public class HelloOtus {
    public static void main(String[] args) {
        Map immutableMap = ImmutableMap.of("one", 1, "two", 2);
        immutableMap.entrySet().stream().forEach(System.out::println);
    }
}