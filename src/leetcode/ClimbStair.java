package leetcode;

public class ClimbStair {
	 public int climbStairs(int n) {
	        // n = 4  
	        // 1 + 1 + 1 +1
	        // 1 + 2 + 1 
	        // 1 + 1 + 2
	        // 2 + 1 + 1
	        // 2 + 2
	        
	        // n =5 
	        // 1 + 1 + 1 + 1 + 1
	        // 1 + 1 + 1 + 2
	        // 1 + 1 + 2 + 1
	        // 1 + 2 + 1 + 1
	        // 1 + 2 + 2
	        // 2 + 1 + 1 +1
	        // 2 + 1 + 2
	        // 2 + 2 + 1
	        // ideas: brutal force : two pointer i and j O(n^2)
	        // i will be 1 then try with all j that can reach the number
	                    
	        // ideas2 : recursive n = climStats(n-2) + climStats(n-1) O(n)
	        /*    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
	}*/
		 // idea3: Dynamic Program
	        if (n<=2) return n;
	        int[] memo = new int[n + 1];

	        for (int i = 1 ; i <= 2; i ++){
	            memo[i] = i;
	        }
	        for (int i = 3 ; i <= n ; i ++){
	            memo[i] = memo[i-1] + memo[i-2];
	        }
	        return memo[n];
	    }
}
