class Solution {
    Integer[][][] dp;
    public int maximumLength(int[] nums, int k) {
        dp = new Integer[nums.length+1][nums.length+1][26];
        return hlp( nums ,0 , k , -1 );
    }

    public int hlp(int[] nums , int ind , int k , int prev ){
        if( ind == nums.length) return 0;
        int max = 0;

        if( prev!= -1 && dp[ind][prev][k] != null) return dp[ind][prev][k];

        if( prev == -1){
            max = Math.max( max , 1 + hlp( nums , ind+1 , k , ind));
            max = Math.max( max , hlp( nums , ind+1 , k , prev));
        }
        else if( k > 0 ){
            if( nums[prev] == nums[ind])
                max = Math.max( max , 1 + hlp( nums , ind+1 , k , ind));
            else{
                max = Math.max( max , 1 + hlp( nums , ind+1 , k-1 , ind) );
                max = Math.max( max ,  hlp( nums , ind+1 , k , prev) );
            }
        }
        else{
            if( nums[prev] == nums[ind])
                max = Math.max( max , 1 + hlp( nums , ind+1 , k , ind));
            else
                max = Math.max( max ,  hlp( nums , ind+1 , k , prev) );
        }
        if( prev != -1)
        dp[ind][prev][k] = max;
        return max;
    }
}