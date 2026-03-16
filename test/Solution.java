import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int fkl(int[] nums, int k) {
        qs(nums, 0, nums.length - 1);
    }

    private void qs(int[] nums, int left, int right) {
        if (right >= left) return;
        int p = partition(nums, left, right);
        qs(nums, left, p);
        qs(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        int i = left, j = right;
        while (i<j) {
            while (i < j && nums[left] <= temp) i++;
            while (i < j && nums[right] > temp) j--;

        }

    }

    // 1432219
    //dailyTemperatures
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3));

    }

}

