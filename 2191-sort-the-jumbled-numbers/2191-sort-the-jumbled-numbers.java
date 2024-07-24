class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
       List<Integer> dummy= new ArrayList<>();
       for(int i:nums)
       dummy.add(i);
    //    Collections.sort(dummy,new Comparator<Integer>(){
    //     @Override
    //     public int compare(Integer a,Integer b){
    //         int a1=map(mapping,a);
    //         int b1=map(mapping,b);
    //         return Integer.compare(a1,b1);
    //     }
    //    });
       Collections.sort(dummy, (a, b) -> Integer.compare(map(mapping, a), map(mapping, b)));
       for(int i=0;i<dummy.size();i++)
       nums[i]=dummy.get(i);
       return nums;
    }
    public int map(int[] m ,int x){
        if(x==0)
        return m[0];
        int ret=0;
        int count=0;
        while(x>0){
            ret=(int)Math.pow(10,count++)*m[x%10] + ret;
            x=x/10;
        }
        return ret;
    }
}