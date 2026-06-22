class Solution {
    public boolean isCorrect( long n , int x){
        long first = n%10;
        long last = 0 ;
        while( n > 0){
            last = n%10;
            n = n/10;
        }
        if( first == last && first == x )
            return true;
        return false;
    }
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        for( int i=0 ;i<nums.length ; i++){
            long sum = 0;
            for( int j = i ; j < nums.length ; j++){
                sum += nums[j];
                if( isCorrect(sum , x)) count++;
                // System.out.println(sum);
            }
            
        }
        return count;
    }
}