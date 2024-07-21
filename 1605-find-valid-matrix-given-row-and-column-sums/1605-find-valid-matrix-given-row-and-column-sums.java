class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for(int i=0;i<rowSum.length;i++){
            for(int j=0;j<colSum.length;j++){
                int sub = Math.min(rowSum[i],colSum[j]);
                matrix[i][j]=sub;
                rowSum[i]-=sub;
                colSum[j]-=sub;
            }
        }
        return matrix;
    }
}