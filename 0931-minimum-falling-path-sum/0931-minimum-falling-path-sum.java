class Solution {
    public int minFallingPathSum(int[][] matrix) {
        dp = new Integer[matrix.length+1][matrix[0].length+1];
        int ret = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
            ret = Math.min(ret ,  hlp( matrix , 0 , i));

        return ret;
    }
    Integer[][] dp;
    public int hlp(int[][] matrix , int row , int col ){
        int ret = Integer.MAX_VALUE ; 
        if(dp[row][col]!= null) return dp[row][col];
        if(row + 1 < matrix.length ){
            ret = Math.min(ret , matrix[row][col] + hlp( matrix , row + 1 , col));
            if(col - 1 >= 0 )
                ret = Math.min(ret , matrix[row][col] + hlp( matrix , row + 1 , col - 1 ));
            if(col + 1 < matrix[0].length)
                ret = Math.min(ret , matrix[row][col] + hlp( matrix , row + 1 , col + 1 ));
        }
        else return matrix[row][col];
        return dp[row][col]=ret;
    }
}