public class BCS6649_Exp_Ten {

    static boolean isSubsetSum(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;
        if (isSubsetSum(arr, n, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}
