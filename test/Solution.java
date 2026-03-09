import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int curSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(curSum - target) < Math.abs(sum - target)) {
                    sum = curSum;
                } else if (curSum < target) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return sum;
    }

    public String minWindow(String s, String t) {
        int left = 0, right = 0, match = 0, start = 0, end = s.length() - 1;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                match++;
            }
            if (match == need.size()) {
                if (end - start >= right - left) {
                    start = left;
                    end = right;
                }
                while (left < right) {
                    char d = s.charAt(left);
                    if (window.get(d).equals(need.get(d))) {
                        match--;
                    }
                    window.put(d, window.get(d) - 1);
                    left++;
                }
            }
            right++;
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 20, 1, 1, 3};
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }


}