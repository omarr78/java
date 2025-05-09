## Implementation 

### Sort Class
```java

package org.example;

public class Sort {
    static int[] bubble_sort(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size - 1; i++) {
            boolean ch = true;
            for(int j = 1; j < size - i ;j++){
                if(arr[j] < arr[j-1]){
                    ch = false;
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            if(ch)break;
        }
        return arr;
    }
    static int[] selection_sort(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size - 1; i++) {
            int min_index = i;
            for(int j = i;j< size;j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            if(min_index != i){
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    static int[] insertion_sort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift right
                j--;
            }
            arr[j + 1] = key;  // Insert key in correct position
        }
        return arr;
    }
}
```
Main Class 

## Implementation

```java

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
```
