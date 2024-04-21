import java.util.*;

public class BCS6649_Exp_Eight {
    static int unboundedKnapsack(int k, int[] arr) {
        int n = arr.length;
        int[] dp = new int[k + 1];
        
        // Initialize dp array
        Arrays.fill(dp, 0);
        
        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            // Update dp array for each possible sum up to k
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
            }
        }
        
        return dp[k];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of array
            int k = scanner.nextInt(); // Target sum
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            int result = unboundedKnapsack(k, arr);
            System.out.println(result);
        }
        
        scanner.close();
    }
}
