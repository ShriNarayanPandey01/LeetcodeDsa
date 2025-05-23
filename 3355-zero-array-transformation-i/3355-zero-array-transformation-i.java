class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] q = new int[nums.length+1];
        for(int[] Q : queries){
            q[Q[0]]++;
            if(q[Q[1]] != q[Q[0]])
            q[Q[1]+1]--;
        }
        int prev = 0;
        for(int i = 0 ; i < nums.length ;i++){
            q[i+1] = prev + q[i];
            prev = q[i+1];

            if(q[i] < nums[i]) return false;
        }
        return true;
    }
}