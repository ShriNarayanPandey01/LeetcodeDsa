class Solution {
    int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        long[][] dp = new long[t+1][26];
        long count = 0;
        for(int i =0 ;i<s.length() ; i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i = 0 ; i <26 ; i++)
        count = (count +  (freq[i]*help(i , t , dp))%MOD)%MOD;
        return (int)count;


    }
    public long help( int v , int t , long[][] dp){
        if(t <=0  ) return 1;
        if(dp[t][v] > 0 ) return dp[t][v];
        long a =  help((v+1)%26 , t-1 , dp);
        if((v+1) == 26)
        a = (a + help(1 ,  t-1 , dp))%MOD;

        dp[t][v] = a;
        return a;
    }
}



class Solution2 {
    public int lengthAfterTransformations(String s, int t) {
        long count = 0;
        int MOD = 1000000007;
        for(int i = 0 ; i<s.length() ; i++){
            int firstDouble =('z' - s.charAt(i));
            if(firstDouble >= t){
                count= (count + 1)%MOD;
                continue;
            }
            int div1 = (t-firstDouble)/25;
            int div2 = (t-firstDouble)/26;
            System.out.println(div1+" "+div2);
            count = (count + ((long)Math.pow(2,div1) + (long)Math.pow(2,div2))%MOD)%MOD;
        }
        return (int)(count%MOD);
    }
}