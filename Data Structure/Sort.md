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
    static int[] merge_sort(int[] arr) { // time complexity o(n log(n)) , space complexity o(n) 
        int l = 0 , r = arr.length - 1;
        if(l == r){
            int []ret = new int[1];
            ret[0] = arr[l];
            return ret;
        }
        int mid = l + (r - l) / 2;
        int []arr1 = new int[mid+1];
        int []arr2 = new int[r-mid];
        for(int i = 0; i <= mid; i++){
            arr1[i] = arr[i];
        }
        for(int i = mid+1,j = 0; i <= r; i++,j++){
            arr2[j] = arr[i];
        }
        int []newArr1 = merge_sort(arr1);
        int []newArr2 = merge_sort(arr2);
        int []finalArr = new int[newArr1.length+newArr2.length];
        int i=0,j=0,k=0;
        while(i < newArr1.length && j < newArr2.length){
            if(newArr1[i] < newArr2[j]){
                finalArr[k++] = newArr1[i++];
            }
            else{
                finalArr[k++] = newArr2[j++];
            }
        }
        while(i< newArr1.length){
            finalArr[k++] = newArr1[i++];
        }
        while(j < newArr2.length){
            finalArr[k++] = newArr2[j++];
        }
        return finalArr;
    }
}
```
Main Class 

## Implementation

```java

package org.example;

import java.util.Random;

public class Main {
    public boolean is_sorted(int []arr){
        for(int i = 1;i<arr.length;i++){
            if(arr[i] < arr[i-1])return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }

        System.out.println("\n" + "Before:" + "\n");
        for(int i : numbers) {
            System.out.println(i);
        }

        int[] nums =  Sort.merge_sort(numbers);

        System.out.println("\n" + "After:" + "\n");
        for(int i : nums) {
            System.out.println(i);
        }
        System.out.println(main.is_sorted(nums));

    }
}
```
