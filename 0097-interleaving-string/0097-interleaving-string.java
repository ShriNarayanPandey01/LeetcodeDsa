class Solution {
    Boolean[][] dp ;
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if( s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return hlp( s3 , s1 ,s2 , 0 , 0 , 0 , 0 , 0 , 'a' );
    }
    public boolean hlp( String s3 ,String s1 ,String s2 ,int n ,int m ,int i1 ,int i2 ,int i3 ,char last){
        if( i3 == s3.length()) return true;
        if(dp[i1][i2] != null) return dp[i1][i2];
        boolean ret = false;
        if( (n > m || last == 'm' || n == m ) && i1 < s1.length()){
            if( s3.charAt(i3) == s1.charAt(i1)){
                ret = hlp( s3 , s1 , s2 , n , m + ( last == 'm' ? 0 : 1) , i1+1 , i2 , i3+1 , 'm'  );
                if (ret == true){ 
                    dp[i1][i2] = true;
                    return true;
                }
            }
        }
        if( (n < m || last == 'n' || n == m ) && i2 < s2.length()){
            if( s3.charAt(i3) == s2.charAt(i2)){
                ret = hlp( s3 , s1 , s2 , n + ( last == 'n' ? 0 : 1) , m  , i1 , i2 + 1 , i3+1 , 'n'  );
                if (ret == true) {
                    dp[i1][i2] = true;
                    return true;
                }
            }
        }
        dp[i1][i2] = false;
        return ret;
    }
}