class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        long prefSum = 0;
        for(int i = 0; i < nums.length ; i++){
            totalSum += nums[i];
            // nums[i] = (int)(totalSum % p);
            prefSum += nums[i];
        }

        int modDiv = (int)(totalSum % p);
        if( modDiv == 0 ) return 0;
        HashMap<Integer , Integer > map = new HashMap<>();
        map.put(0,-1);

        long prev = 0 , ret = Integer.MAX_VALUE;
        // System.out.println(prefSum+" "+totalSum+" "+modDiv);
        for(int i = 0 ;i< nums.length ;i++){
            
            prev += nums[i];
            int key =(int)(prev % p);
            // System.out.print(key +" ");
            int needed = (key + p - modDiv) % p;
            if( map.containsKey(needed)){
                ret = Math.min( ret , i - map.get(needed));
            }
            map.put(key , i);
        }
        System.out.println(ret);
        if(ret == Integer.MAX_VALUE || ret == nums.length) return -1;
        return (int)ret;
    }

}