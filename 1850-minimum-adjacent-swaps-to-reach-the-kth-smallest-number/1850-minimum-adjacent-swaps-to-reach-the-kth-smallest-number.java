class Solution {
    public int getMinSwaps(String nums, int k) {
        int[] org = new int[nums.length()];
        int[] arr = new int[nums.length()];
        for(int i=0;i<nums.length();i++){
            arr[i]=nums.charAt(i)-'0';
            org[i]=arr[i];
        }
        
        for(int i=0;i<k;i++)
            nextPermutation(arr);
        int i;
        for(i=0;i<arr.length;i++)
            if(arr[i]!=org[i])
                break; 
        int count=0; 
        for(int j=i;j<nums.length();j++){
            int m=j;
            while(m<nums.length() && org[m]!=arr[j]){
                count++;m++;
            }
        }      
        return count-1;
    }
    public void reverse(int[] arr){
        int temp=0;
        int start=0,end=arr.length-1;
        while(start<end){
        temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        end--;start++;
    }
    }
    public void changes(int[] arr,int n){
    int temp,flag=0;
    for(int i=arr.length-1;i>n;i--){
        if(arr[i]>arr[n])
        {   
            temp=arr[i];
            arr[i]=arr[n];
            arr[n]=temp;
            break;
        }
    }
    int end=arr.length-1;
    int start=n+1;
    while(start<end){
        temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        end--;start++;
    }
    }
    public void nextPermutation(int[] nums) {
        int start,flag=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                start=i;
                flag=0;
                changes(nums,start);
                break;
            }
        }
        if(flag==1)
        reverse(nums);
    }
}