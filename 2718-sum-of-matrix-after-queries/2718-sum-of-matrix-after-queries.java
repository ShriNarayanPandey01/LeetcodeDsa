class Solution {
    public long matrixSumQueries(int n, int[][] q) {
        int totalCell = n*n;
        int[] r = new int[n];
        int[] c = new int[n];
        long sum = 0;
        for( int i =  q.length - 1 ; i>=0  ; i--){
            int[] queries = q[i];
            if( queries[0] == 0){
                int row =  queries[1];
                for( int j = 0 ; j < n ; j++)
                    if( r[row] == 0 && c[j] == 0  ){
                        totalCell--;
                        // ret[row][j] = queries[2];
                        sum += queries[2];
                    }
                    r[row] = 1;
            }
            else{
                int col =  queries[1];
                for( int j = 0 ; j < n ; j++)
                    if( r[j] == 0 && c[col] == 0 ){
                        totalCell--;
                        // ret[j][col] = queries[2];
                        sum += queries[2];
                    }
                    c[col]=1;
            }
            if( totalCell == 0 ) break;
        }
        return sum;

    }
}