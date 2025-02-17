package concepts.arraysStrings;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        int[] input2 = input.clone();
        rotate(input, k);
        rotateInPlace(input2, k);
        Arrays.stream(input).forEach(e -> System.out.print(e + " "));
        System.out.println("\n");
        Arrays.stream(input2).forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    //O(n) - But requires two passes - One to copy array
    //Also O(n) space
    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0 || k == nums.length) {
            return;
        }
        int pointer;
        if (k > nums.length) {
            pointer = 2 * nums.length - k;
        } else {
            pointer = nums.length - k;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (pointer == nums.length) {
                pointer = 0;
            }
            res[i] = nums[pointer++];
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }

    //Inplace
    private static void rotateInPlace(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k <= 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}