/* Given an array of positive integers. Your task is to rearrange the array elements alternatively
 *  i.e., first element should be the max value, the second should be the min value,
 *  the third should be the second max, the fourth should be the second min, and so on.
 *  Note: Modify the original array itself. Do it without using any extra space.
 *  You do not have to return anything.*/

public class P006a_RearrangeArrayAlternatively {
    public static void rearrangeAlternatively(int[] arr) {
        int n = arr.length;
        int key = arr[n-1] + 1;
        int k = n - 1;
        int j = 0;

        for(int i = 0; i < n; i++) {
//          even should be max
            if(i%2==0) {
                arr[i] = ((arr[k] % key) * key) + arr[i];
                k--;
            }
//          odd should be min
            else {
                arr[i] = ((arr[j] % key) * key) + arr[i];
                j++;
            }
        }
        for(int i = 0; i < n; i++) {
            arr[i] /= key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        rearrangeAlternatively(arr);
        System.out.print("The altered array is: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}