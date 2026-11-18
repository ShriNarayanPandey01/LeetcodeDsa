class Solution {
    public int trailingZeroes(int n) {
        int five = 0 , even = 0 , zero = 0;
        for( int i = 1 ; i <= n ; i++ ){
            if( i%5 == 0 ){
                int temp = i ;
                while( temp > 0 && temp%5 == 0){
                    temp = temp/5;
                    five++;
                }
            }
            else if ( i%2 == 0){
                int temp = i ;
                while( temp > 0 && temp%2 == 0){
                    temp = temp/2;
                    even++;
                }
            }   
            
        }
        return Math.min(even , five);
    }
}