// Given two sorted arrays, the task is to merge them in a sorted manner.
public class P005_MergeTwoSortedArrays {
    // Using the GAP METHOD - SHELL SORT
    public static void mergeArrays(long[] arr1, long[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int len = (n + m);
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // arr1 & arr2
                if(left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // arr2 & arr2
                else if(left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // arr1 & arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swapIfGreater(long[] arr1, long[] arr2, int idx1, int idx2) {
        if (arr1[idx1] > arr2[idx2]) {
            long temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 3, 5, 7};
        long[] arr2 = {0, 2, 6, 8, 9};

        mergeArrays(arr1, arr2);

        // Printing merged arrays
        System.out.println("The merged array is: ");
        for (long num : arr1) {
            System.out.print(num + " ");
        }
        for (long num : arr2) {
            System.out.print(num + " ");
        }
    }
}