import java.util.ArrayList;
import java.util.List;

class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return Math.max(dp[n - 1][0], 0);
    }

    //findDuplicateSubtrees
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(solution.wordBreak("aaaaaaa", wordDict));
    }

}

