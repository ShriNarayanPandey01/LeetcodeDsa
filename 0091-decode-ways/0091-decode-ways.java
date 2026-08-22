class Solution {
    Integer[] dp ;
    public int numDecodings(String s) {
        dp = new Integer[s.length() + 1];
        return hlp(s,0);
    }

    public int hlp( String s  , int ind){
        if( ind == s.length()) return 1;
        if( s.charAt(ind) == '0') return 0;
        if( dp[ind] != null) return dp[ind];
        int a = hlp( s , ind + 1);
        
        if(ind < s.length()-1 && Integer.parseInt( s.substring(ind, ind + 2)) < 27){
            a += hlp( s , ind + 2);
        }
        dp[ind] = a;
        return a;
    }
}


// f( string  , ind  )
//     if( string[ind] == '0' ) return 0;
//     if( ind == string.length  ) return 1;

//     a = f( string , ind + 1);
//     if( int(string[ind] + string[ind+1])<26)
//     a += f( string , ind + 2);
//     return a;
    