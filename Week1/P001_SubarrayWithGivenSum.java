import java.util.Arrays;
import java.util.Scanner;

public class P001_SubarrayWithGivenSum {
    // Function to find a continuous sub-array which adds up to a given number
    public static int[] subarraySum(int[] arr, int n, int targetSum) {
        int currSum = 0;
        int left = 0;

        for(int right = 0; right < n; right++) {
            currSum += arr[right];

            while(currSum > targetSum && left <= right) {
                currSum -= arr[left];
                left++;
            }

            if(currSum == targetSum) {
                return Arrays.copyOfRange(arr, left, right + 1);
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + "Elements: ");

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter Sum: ");
        int targetSum = sc.nextInt();

        int[] result = subarraySum(arr, n, targetSum);

        if(result != null) {
            System.out.print("Subarray with given sum " + targetSum + ": ");
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("No subarray with sum " + targetSum + " found.");
        }
    }
}