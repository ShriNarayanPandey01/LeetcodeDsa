class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
    public void merge(int[] arr , int start , int end){
        if(start<end){
            int mid = (start + end)/2;
            merge(arr , start , mid);
            merge(arr , mid+1, end);
            sort(arr,start,mid,end);
        }
    }
    public void sort(int[] arr , int start , int mid , int end){
        int ind = start;
        int i=start,j=mid+1;
        List<Integer> ret = new LinkedList<>();
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                ret.add(arr[i++]);
            }
            else{
                ret.add(arr[j++]);
            }
        }
        while(i<=mid) ret.add(arr[i++]);
        while(j<=end) ret.add(arr[j++]);
        for(int k:ret)
        arr[ind++]=k;
    }
}