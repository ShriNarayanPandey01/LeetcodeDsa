class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int[] pref = new int[nums.length];
        int min = 0 ;
        int max = 0 ;
        int prev = 0 ;
        for(int i =0 ; i<nums.length ; i++){
            pref[i] = nums[i]+prev;
            prev = pref[i];
            if(prev < min ) {
                min = prev;
            }
            if(prev > max){
                max = prev;
            }
        }
        return (int)Math.abs(max - min);
    }
}