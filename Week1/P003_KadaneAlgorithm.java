/* Given an array arr[], the task is to find the subarray
 *  that has the maximum sum and return its sum. */

public class P003_KadaneAlgorithm {
    public static int maxSumSubarray(int[] arr) {
        int maxSum = 0;
        int currSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("Maximum Sum of Subarray is: " + maxSumSubarray(arr));
    }
}