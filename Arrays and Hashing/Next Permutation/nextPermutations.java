class Solution {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the break point
        int index = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If the break point does not exist, reverse the whole array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Step 2: Find the next greater element and swap it with nums[index]
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 3: Reverse the right half
        reverse(nums, index + 1, n - 1);

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
