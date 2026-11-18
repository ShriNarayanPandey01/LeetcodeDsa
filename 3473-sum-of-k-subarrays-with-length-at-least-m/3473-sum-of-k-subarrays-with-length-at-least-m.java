class Solution {
    int[] prefix;
    Integer[][] dp;
    public int maxSum(int[] nums, int k, int m) {
        prefix = new int[nums.length + 1];
        for( int i = 0 ; i < nums.length ; i++){
            prefix[i+1] = prefix[i]+nums[i];

        }
        dp = new Integer[nums.length+1][k+1];

        
        int extra = nums.length - k*m;
        return hlp( nums , k , m , 0 , extra);
    }

    public int hlp( int[] nums , int k , int m , int ind , int extra ){
        if( k == 0 ) return 0;
        if( dp[ind][k] != null) return dp[ind][k];
        int max = Integer.MIN_VALUE;
        if( extra > 0 ){
            max = hlp( nums  , k  , m , ind+1 ,  extra - 1);
        }
        int prev = Integer.MIN_VALUE;
        for( int i = ind+m-1 ; i < (ind+extra+m) ; i++){
            int sum = prefix[i+1] - prefix[ind] ;
            if( sum >= prev){
                max = Math.max( max , sum + hlp( nums , k -1 , m , i+1 , (extra - ( i - (ind+m-1) )) ));
                prev = sum;
            }
        } 
        dp[ind][k] = max;
        return max;
    }
}