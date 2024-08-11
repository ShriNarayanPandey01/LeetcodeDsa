class Solution1 {
    
    HashMap<Integer,Integer> map= new HashMap<>();
    public int jump(int[] nums) {
        HashMap<Integer,Integer> visit= new HashMap<>();
        return check(nums,visit,0,nums.length-1);
    }
    public int check(int[] nums,HashMap<Integer,Integer> visit,int init,int target){
        if(init==target)
        return 0;
        
        if(map.containsKey(init))
        return map.get(init);
        

        visit.put(init,1);
        int min = 10001;
        for(int i=init+1;i<nums.length && i<=init+nums[init];i++){
            int hold=1+check(nums,visit,i,target);
            min=Math.min(min,hold);

        }
        map.put(init,min);
        return map.get(init);

    }
}
class Solution2 {
    int min=Integer.MAX_VALUE;
    public int helper(int nums[],int index,int count,int dp[])
    {
        if(index==nums.length-1)
        {
        min=Math.min(min,count);
        return count;
        }
        if(dp[index]!=-1)
        {
            count=count+dp[index];
            min=Math.min(min,count);
            return count;
        }
        System.out.println(index);
        int indmin=Math.min(index+nums[index],nums.length-1);
        
        for(int i=index+1;i<=indmin;i++)
        {
           int a= helper(nums,i,count+1,dp);
           dp[index]=(a-count);
        }
        return min;
    }
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int a=helper(nums,0,0,dp);
        return min;
    }
}
class Solution {
    
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1000000);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n&&j<=i+nums[i];j++){
                dp[i]=Math.min(1+dp[j],dp[i]);
            }
        }
        return dp[0];
    }
}
