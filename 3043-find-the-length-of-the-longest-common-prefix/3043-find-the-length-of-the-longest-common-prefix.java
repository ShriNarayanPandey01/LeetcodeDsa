class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for( int i = 0 ; i < arr1.length ; i ++){
            int nums = arr1[i] ;
            while( nums > 0 ){
                map.put(nums,1);
                nums=nums/10;
            } 
        }
        int max = 0 ;
        for ( int i : arr2 ){
            int nums = i ;
            while( nums > 0 ){
                if( map.containsKey( nums )){
                max = Math.max(max, nums);
                break;
                }
                nums=nums/10;
            } 
        }
        if(max == 0 ) return 0;
        return len(max);
    }
    public int len(int n){
        int l = 0 ;
        while(n>0) {
            n=n/10;
            l++;
            }
        return l;
    }
}