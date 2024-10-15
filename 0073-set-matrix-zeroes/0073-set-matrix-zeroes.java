class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer,Integer> row= new HashMap<>();
        HashMap<Integer,Integer> column= new HashMap<>();
        for(int i=0;i<matrix.length;i++)
        for(int j=0;j<matrix[0].length;j++)
        {   if(matrix[i][j]==0)
            {if(!row.containsKey(i))
            row.put(i,0);
            if(!column.containsKey(j))
            column.put(j,0);
        }}
        for(int i=0;i<matrix.length;i++)
        for(int j=0;j<matrix[0].length;j++){
            if(row.containsKey(i) || column.containsKey(j))
            matrix[i][j]=0;
        }
     
    }
}