/* Given an array arr[] of size n-1 with integers in the range of [1, n],
 *  the task is to find the missing number from the first n integers.*/

public class P004_MissingNumberInArray {
    public static int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int XOR1 = 0;
        int XOR2 = 0;

        for(int i = 0; i < arr.length; i++) {
            XOR1 = XOR1 ^ (i + 1);
            XOR2 = XOR2 ^ arr[i];
        }
        XOR1 = XOR1 ^ n;
        return (XOR1 ^ XOR2);

        /* The other optimal method to solve this questions:

        int sum = ((n * (n + 1)) / 2);
        int sum2 = 0;
        for(int i = 0; i < arr.length; i++) {
            sum2 += arr[i];
        }
        return (sum  - sum2);

        Problem with this solution is that when n = 10^5, sum will be 10^10 for which
        the space 'int' can provide isn't sufficient, and we need to use 'long'
        due to which we need to use a slight more memory hence it's comparatively less optimal
        for larger test cases.
        */
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        System.out.println("The Missing number from the given array is: " + missingNumber(arr));
    }
}