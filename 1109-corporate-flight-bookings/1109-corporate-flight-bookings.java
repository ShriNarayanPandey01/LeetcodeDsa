class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n];
        int[] prefix = new int[n];
        for( int[] i : bookings){
            if( i[0] <= n )
                prefix[i[0]-1] += i[2];
            if( i[1] < n )
                prefix[i[1]] -= i[2];
        }
        int prev = 0;
        for( int i = 0 ; i < n ;i++){
            ret[i] = prefix[i] + prev;
            prev = ret[i];
        }
        return ret;
    }
}