class Solution {
    public int numMagicSquaresInside(int[][] grid) {
       int count=0;
       for(int i=0;i<=grid.length-3;i++){
        for(int j=0;j<=grid[0].length-3;j++){
            if(chk(grid,i,j)) count++;
        }
       }
        
       return count;
    }
   

    public boolean chk(int[][] grid ,int i,int j){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ds = new HashSet<>();

        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(grid[k][l]==0 || grid[k][l]>9)
                return false;
                ds.add(grid[k][l]);

            }
        }
        int max = -1;
        int a11 = grid[i][j];
        int a12 = grid[i][j+1];
        int a13 = grid[i][j+2];
        int a21 = grid[i+1][j];
        int a22 = grid[i+1][j+1];
        int a23 = grid[i+1][j+2];
        int a31 = grid[i+2][j];
        int a32 = grid[i+2][j+1];
        int a33 = grid[i+2][j+2];
        set.add(a11 + a12 + a13);
        set.add(a21 + a22 + a23);
        set.add(a31 + a32 + a33);
        set.add(a11 + a22 + a33);
        set.add(a31 + a22 + a13);
        set.add(a11 +a21 +a31);
        set.add(a12 +a22 +a32);
        set.add(a13+a23+a33);
        if(set.size()==1 && ds.size()==9 && max<=9)
        return true;
        else return false;
         
    }
}