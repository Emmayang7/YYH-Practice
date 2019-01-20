//Leetcode 279

class Solution {
    public int numSquares(int n) {
        if(n<0){
            return 0;
        }
        int [] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); //Arrays.fill,...Integer.MAX_VALUE
        dp[0] = 0;
        for(int i=1; i< n+1; i++){ //MAX int is INT_MAX find the largest square
            int j=1;
            while(i - j*j >= 0){ //we found the boundary
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }
}
