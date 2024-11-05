class Solution {
    public int maximumGap(int[] nums) {
        
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
            min = Math.min( min , nums[i]);
            max = Math.max( max , nums[i]);
        }
        int gap = (int)Math.ceil((max - min)/set.size());
        set.clear();
        int[][] bucket = new int[nums.length+1][2];
        for (int[] i : bucket)
            Arrays.fill(i,-1);
        System.out.println(gap);
        if (nums.length <= 1 || gap == 0) return 0;
        for( int i  = 0 ; i < nums.length ; i++){
            int ind = (int)Math.floor((nums[i]-min)/gap);
            bucket[ind][0] = bucket[ind][0] == -1 ? nums[i] : Math.min(nums[i] , bucket[ind][0]);
            bucket[ind][1] = Math.max( bucket[ind][1] ,nums[i]);
        }
        int max_gap = gap ;
        int prev = 0;
        for ( int  i = 1 ; i < bucket.length ; i ++){
            if( bucket[i][0] == -1) continue;
            else{
                gap = bucket[i][0] - bucket[prev][1];
                max_gap = Math.max(gap , max_gap);
                prev = i;
            } 
        }
        return max_gap;
    }
}