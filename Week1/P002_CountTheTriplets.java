import java.util.Arrays;

/* Program to count triplets such that at least one of the numbers
*  can be written as a sum of the other two */
public class P002_CountTheTriplets {
    public static int countTripletsWays(int[] arr) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);

        // Traverse the array from the last element to the third element
        for(int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            // Use the two-pointer approach to find pairs that sum up to arr[i]
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == arr[i]) {
                    count++; // Fount a triplet
                    left++;
                    right--;
                } else if (sum < arr[i]) {
                    left++; // Increase the sum by moving the left pointer
                } else {
                    right--; // Decrease the sum by moving the right pointer
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int result = countTripletsWays(arr);

        System.out.println("Number of triplets: " + result);
    }
}