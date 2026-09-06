class Solution {
    public long matrixSumQueries(int n, int[][] q) {
        int totalCell = n*n;
        int[] row = new int[n];
        int[] col = new int[n];
        int r = n;
        int c = n;
        long sum = 0;
        for( int i =  q.length - 1 ; i>=0  ; i--){
            int[] queries = q[i];
            if( queries[0] == 0){
                if( row[queries[1]] == 0){ 
                    sum += c*queries[2];
                    r--;
                    row[queries[1]] = 1;
                }
            }
            else{
                if( col[queries[1]] == 0){
                    sum += r*queries[2];
                    c--;
                    col[queries[1]] = 1;
                }
            }
            if( r == 0  && c == 0) break;
        }
        return sum;

    }
}