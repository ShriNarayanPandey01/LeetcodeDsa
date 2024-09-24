import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        List<int[]>[][] ar = new ArrayList[matrix.length][matrix[0].length];
        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                ar[row][col] = new ArrayList<>();
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int prefix = 0;
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                if (matrix[row][col] == '0') {
                    int[] temp = new int[]{0, 0};
                    // System.out.println(" zero occurrence " + row + " " + col);
                    ar[row][col].add(temp);
                    prefix = 0;
                    continue;
                } else if (col == matrix[0].length - 1 && row == 0) { // RIGHTMOST COLUMN TopMost row
                    int[] temp = new int[]{1, 1};
                    ar[row][col].add(temp);
                    max = Math.max(1, max);
                    prefix = 1;
                } else if (col == matrix[0].length - 1 && row != 0) { // rightmost col general row
                    int[] temp1 = ar[row - 1][col].get(0);
                    int[] temp = new int[2];
                    temp[0] = temp1[0] + 1;
                    temp[1] = 1;
                    max = Math.max(max, temp[0] * temp[1]);
                    ar[row][col].add(temp);
                    prefix = 1;
                } else if (row == 0) { // Top row General col
                    int[] temp1 = ar[row][col + 1].get(0);
                    int[] temp = new int[2];
                    temp[0] = 1;
                    temp[1] = temp1[1] + 1;
                    ar[row][col].add(temp);
                    if(row==0 && col==0)
                        System.out.println(temp[0] + " " + temp[1]);
                    max = Math.max(max, temp[0] * temp[1]);
                    prefix += 1;
                } else { // general row general column
                    prefix += 1;
                    int[] right = {1, prefix};
                    max = Math.max(max, 1 * prefix);
                    ar[row][col].add(right);
                    List<int[]> up = ar[row - 1][col];
                    for (int[] i : up) {
                        // if(row == 15 && col == 0)
                        //     System.out.println(i[0]+" "+i[1]+" "+prefix);
                        if (i[1] > prefix) {
                            ar[row][col].add(new int[]{i[0] + 1, prefix});
                            max = Math.max(max, prefix * (i[0] + 1)); 
                            continue ;
                        }
                        max = Math.max(max, i[1] * (i[0] + 1)); 
                        ar[row][col].add(new int[]{i[0] + 1, i[1]});
                    }
                }
            }
        }
        return max;
    }
}
