class Solution {
    public int removeDuplicates(int[] nums) {
        int insert=0;
        int move=0;
        int count=1;
        int k=1;
        int i=0;
        for(i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            if(nums[i]!=nums[i-1]){
                if(count>=2)
                {nums[insert++]=nums[i-1];nums[insert++]=nums[i-1];k+=2;count=1;}
                else
                {nums[insert++]=nums[i-1];k++;}
            
            }
        }
        if(count>=2)
        {nums[insert++]=nums[i-1];nums[insert++]=nums[i-1];k+=1;count=1;}
        else
        {nums[insert++]=nums[i-1];}
        return k;
    }
}