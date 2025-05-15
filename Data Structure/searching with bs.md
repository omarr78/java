``` java

public class Searching {
    static int findIdx(int x, int[] arr) {
        int l = 0, r = arr.length - 1;

        while (r >= l) {
            int m = l + (r - l) / 2;

            if (arr[m] < x) {
                l = m + 1;
            } else if (arr[m] > x) {
                r = m - 1;
            } else {
                return m; // Found
            }
        }
        return -1;
    }
    int find_first_less_than(int x,int []arr){
        int l = 0,r = arr.length - 1;
        int ans = -1;
        while(r>=l){
            int m = l + (r-l) / 2;
            if(arr[m] <= x){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return ans;
    }
    int find_first_greater_than(int x,int []arr){
        int l = 0,r = arr.length - 1;
        int ans = -1;
        while(r>=l){
            int m = l + (r-l) / 2;
            if(arr[m] >= x){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
}


```
