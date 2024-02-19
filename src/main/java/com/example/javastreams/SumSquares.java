package com.example.javastreams;

import java.util.Arrays;
import java.util.List;

public class SumSquares {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumOfSquares = numbers.stream()
                .mapToInt(num -> num * num)
                .sum();

        System.out.println(sumOfSquares);
// Output: 55
    }

}
