/* Given an array arr[] of size n, the task is to rearrange
 *  it in alternate positive and negative manner without changing
 *  the relative order of positive and negative numbers. */

import java.util.Arrays;

public class P006b_RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int posIdx = 0;
        int negIdx = 1;

        for(int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIdx] = arr[i];
                negIdx += 2;
            } else {
                ans[posIdx] = arr[i];
                posIdx += 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};

        System.out.println("The rearranges array is: " + Arrays.toString(rearrangeArray(arr)));
    }
}