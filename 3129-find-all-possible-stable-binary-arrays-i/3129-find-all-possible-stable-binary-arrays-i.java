class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero+1][one+1][2];
        lmt=limit;
        return hlp(zero, one,-1);
    }
    int lmt;
    long MOD = 1000000007;
    Integer[][][] dp ;
    public int hlp(int z , int o , int lo){
        if(z==0 && o==0)
            return 1;
        if((z==0 && lo==1) || (o==0 && lo==0)){
            return 0;
        }
        if(lo!=-1 && dp[z][o][lo]!=null)
        return dp[z][o][lo];
        long ret = 0;
        // if(o>0 && !(chk==1 && lo==0)){
        //     if(chk==1)
        //     ret = (ret + (long)hlp(val,z,o-1,lo-1,1))%MOD;
        //     else
        //     ret = (ret + (long)hlp(val,z,o-1,val-1,1))%MOD;
        // }
        int limit=lmt;
        for(int i=1;i<=o && limit>0 && (lo!=1||lo==-1) ;i++,limit--)
        ret=(ret+(long)hlp(z,o-i,1))%MOD;
        limit=lmt;
        for(int i=1;i<=z && limit>0 && (lo!=0||lo==-1);i++,limit--)
        ret=(ret+(long)hlp(z-i,o,0))%MOD;
        if(lo!=-1)
        dp[z][o][lo]=(int)ret;
        return (int)ret;
    }
}