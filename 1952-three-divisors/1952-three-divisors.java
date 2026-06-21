class Solution {
    public boolean isThree(int n) {
        int c = 3 ;
        for( int i =  1 ; i <= n ; i++){
            if( n%i == 0) c--;
            if (c == -1) return false;
        }
        if( c == 0) return true;
        return false;
    }
}