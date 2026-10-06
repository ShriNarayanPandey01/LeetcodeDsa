class Solution {
    Integer[][] dp ; 
    public int longestArithSeqLength(int[] nums) {
        dp = new Integer[nums.length + 1][1010];
        return hlp( nums , 0 , -1 , null);
    }
    public int hlp( int[] nums , int ind , int prevInd , Integer diff){
        if( ind == nums.length) 
            return 0;
        if( diff!=null && dp[ind][diff+500] != null ) return dp[ind][diff+500];
        int max = 0;
        
        // max = Math.max(max ,  hlp(nums , ind+1 , prevInd , diff ));

        if( diff == null)
        {
            max = Math.max(max , 1+hlp( nums , ind+1 , ind , prevInd != -1 ? nums[ind]-nums[prevInd] : null ));
            max = Math.max(max ,  hlp(nums , ind+1 , prevInd , diff ));
        }
        else{
            for( int i = ind ; i < nums.length ; i++){
                if( nums[i]-nums[prevInd] == diff ){
                    max = Math.max(max , 1+hlp( nums , i+1 , i , diff ));
                    break;
                }
                    
            }
        }
        
        if( diff != null)
        dp[ind][diff+500] = max;
        return max;
    }   
}