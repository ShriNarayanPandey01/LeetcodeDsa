class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> list=new ArrayList<>();
        int i=0,right=mat[0].length;
        int j=0,bottom=mat.length;
        while(list.size()<right*bottom){
            while(j<mat[0].length && mat[i][j]!=(-101)){
                list.add(mat[i][j]);
                mat[i][j++]=-101;
            }i++;
            j--;
            while(i<mat.length && mat[i][j]!=(-101)){
                list.add(mat[i][j]);
                mat[i++][j]=-101;
            }
            i--;
            j--;
            while(j>=0 && mat[i][j]!=-101 ){
                list.add(mat[i][j]);
                mat[i][j--]=-101;
            }i--;
            j++;
            while(i>=0 && mat[i][j]!=-101){
                list.add(mat[i][j]);
                mat[i--][j]=-101;
            }j++;
            i++;
        }
        return list;
    }}