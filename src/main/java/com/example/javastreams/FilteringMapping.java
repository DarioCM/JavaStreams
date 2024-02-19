package com.example.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringMapping {


    public static void main(String[] args) {
        System.out.println("...");

        List<String> programmingLanguages = Arrays.asList("Java", "Python", "JavaScript", "C++");

        List<String> filteredLanguages =
                programmingLanguages.stream().filter(lang -> lang.startsWith("J")).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(filteredLanguages);
// Output: [JAVA, JAVASCRIPT]
    }


}
