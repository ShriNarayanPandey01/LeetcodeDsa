class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int numOfZero1 = 0 , numOfZero2 = 0;
        long totalSum1 = 0 , totalSum2 = 0  ;
        for(int i : nums1 ){
            if(i == 0) numOfZero1++;
            totalSum1 += i; 
        }
        for(int i : nums2 ){
            if(i == 0) numOfZero2++;
            totalSum2 += i; 
        }


        if( numOfZero1 == 0 && (totalSum2+numOfZero2) > totalSum1   ) return -1;
        if( numOfZero2 == 0 && (totalSum1+numOfZero1) > totalSum2   ) return -1;

        return Math.max((numOfZero2 + totalSum2) , (numOfZero1 + totalSum1) );
                                                                                                                           
    }
}