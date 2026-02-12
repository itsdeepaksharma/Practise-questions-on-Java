package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        // grouping the elemnts of list using stream api
        List<String> list = Arrays.asList("apple", "bat", "cat", "banana", "dog");
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);


        // max and min using stream api
        List<Integer> nums = Arrays.asList(10, 45, 2, 99, 34);
        Integer max = nums.stream().max(Integer::compareTo).get();
        Integer min = nums.stream().min(Integer::compareTo).get();
        System.out.println(min + "    " + max);

        // joining the elements based on delimiter
        List<String> items = Arrays.asList("Milk", "Eggs", "Bread");
        String result = items.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result); // [Milk, Eggs, Bread]


        // Atomic Integer problem of counter
        AtomicCounter ac = new AtomicCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ac.incrementCounter();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                ac.incrementCounter();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(ac.getCounter());



        // jagged arrayy with differenct column size

        int[][] arr = {{4, 5, 6}, {1, 2}, {100, 250, 412, 456}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


         // palindrome
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int left =0; int right = input.length()-1;

        while (left<right){
            if(input.charAt(left)==input.charAt(right))
            {
                System.out.println(input + " is a plaindrome array");
            }
            else
            {
                System.out.println("is not a palindrome");
                break;
            }
            left++;
            right--;
        }






    }
}


class AtomicCounter {

    AtomicInteger counter = new AtomicInteger(0);

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

}