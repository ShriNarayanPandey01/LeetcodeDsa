class Solution {
    public int numTeams(int[] rating) {
        dp = new int[rating.length+1][4][4];
        return hlp(rating,0,0,0);
    }
    int dp[][][];
    public int hlp(int[] rating , int ind , int order ,int count){
        if(ind==rating.length-1)
        if(count==3)
        return 1;
        else return 0;
        int ret1 =0;
        
        if(count==3)
            return 1;

        if(dp[ind][order][count]>0)
        return dp[ind][order][count];
        if(order == 0 ){
                ret1 += hlp(rating,ind,1,1);                
                ret1 += hlp(rating,ind,2,1);
                ret1  += hlp(rating,ind+1,0,0);        
            }
        else
        for(int i=ind+1;i<rating.length;i++){
            if(order==1){
                if(rating[ind]>rating[i])
                ret1 += hlp(rating,i,order,count+1);
            }
            else{
                if(rating[ind]<rating[i])
                ret1 += hlp(rating,i,order,count+1);
            }
        }
        dp[ind][order][count]=ret1;
        return ret1;
       
    }
}