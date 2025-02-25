class Solution {
    int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int[] pref = new int[arr.length+1];
        int odd = 0, even = 0;
        int prev = 0;
        for(int i = 0 ; i <arr.length ; i++){
            pref[i+1] = arr[i]+prev;
            prev = pref[i+1];
            if(pref[i+1]%2 == 0) even++;
            else odd++;
        }
        long ans = 0;
        for( int i = 0 ; i<pref.length ; i++){
            if( pref[i] %2 == 0){
                even--;
                ans = (ans + odd)%MOD;
            }
            else{
                ans = (ans + even + 1)%MOD;
                odd --;
            }
        }
        return (int)(ans);
    }
}