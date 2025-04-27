class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill( dp , -1);
        return helper(questions , 0 , dp);
    }
    public long helper(int[][] arr , int ind ,long[] dp ){
        if(ind >= arr.length ) return 0;
        if(dp[ind]>-1) return dp[ind];
        long ret = 0;
        ret = Math.max(ret , arr[ind][0] + helper(arr , ind + 1 + arr[ind][1] , dp) );
        ret = Math.max(ret , helper(arr , ind + 1 ,dp) );
        dp[ind] =ret;

        return ret;
    }
}