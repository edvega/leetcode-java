package org.example;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static void main() {
        int[] output = productExceptSelf(new int[]{-1,1,0,-3,3});

        System.out.println(Arrays.toString(output));
    }

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 0) {
                nums[i] = product / nums[i];
            } else if (zeroCount >= 2) {
                nums[i] = 0;
            } else {
                if (nums[i] == 0) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            }
        }

        return nums;
    }
}
