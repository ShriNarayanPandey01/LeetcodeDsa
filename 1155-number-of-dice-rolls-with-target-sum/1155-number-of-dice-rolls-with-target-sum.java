class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        dp =  new Integer[n+1][target + 1];
        return hlp(n,0,k,target,0);
    }
    Integer[][] dp ; 
    public int hlp( int n , int curr , int k , int target , int sum){
        if ( curr == n ){
            if( sum == target) return 1;
            else return 0;
        }
        if( curr < n-1 && sum >= target) return 0;

        if(dp[curr][sum] != null) return dp[curr][sum];
        int ret = 0;
        for(int i = 1 ; i <= k ; i++)
            ret += hlp( n , curr+1 ,k, target , sum+i);
        dp[curr][sum] = ret;
        return ret;
    }
}