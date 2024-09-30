class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
         Arrays.sort(maximumHeight);
         int min = maximumHeight[0];
         long score = maximumHeight[maximumHeight.length-1] ;
         for( int i = maximumHeight.length - 2  ; i >=0 ; i --){
            if(maximumHeight[i] >= maximumHeight[i+1]){
                if(maximumHeight[i+1] - 1 <= 0 ) return -1;
                score += maximumHeight[i+1] - 1;
                maximumHeight[i] = maximumHeight[i+1]-1;
            }
            else score+=maximumHeight[i];
         }
         return score;
    }
}