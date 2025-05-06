public class BubbleSort {
    static int[] sort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            boolean ch = true;
            for(int j = 1; j < arr.length - i ;j++){
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
}
