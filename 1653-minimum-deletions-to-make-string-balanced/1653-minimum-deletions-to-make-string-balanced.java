class Solution {
    public int minimumDeletions(String s) {
        dp = new int[s.length()][2];
       return hlp(s,0,0);
    }
    int dp[][];
    public int hlp(String s , int ind , int prev){
        if(ind==s.length()) return 0;
        if(dp[ind][prev]>0)
        return dp[ind][prev];
        int op = Integer.MAX_VALUE;
        if(prev==0){
            if(s.charAt(ind)=='b'){
                op = Math.min(op , 1+hlp(s,ind+1,prev));
                op = Math.min(op , hlp(s,ind+1,1));
            }
            else op = Math.min(op , hlp(s,ind+1,prev));
        }
        else{
            if(s.charAt(ind)=='a')
            op = Math.min(op , 1+hlp(s,ind+1,1));
            else op = Math.min(op ,hlp(s,ind+1,1));
        }
        dp[ind][prev]=op;
        return op;
    }
}