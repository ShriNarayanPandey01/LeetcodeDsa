class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0 ,p = (int)Math.pow(2,maximumBit)-1;
        int[] ret = new int[nums.length];
        int ind = nums.length-1;
        for( int i : nums)
        {
            xor ^= i;
            ret[ind--] = p^xor;
        }
        return ret;
    }
}