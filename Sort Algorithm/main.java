package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[50];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println("\n" + "Before:" + "\n");
        for(int i : numbers) {
            System.out.println(i);
        }

        int[] nums =  Sort.selection_sort(numbers);

        System.out.println("\n" + "After:" + "\n");
        for(int i : nums) {
            System.out.println(i);
        }
    }
}
