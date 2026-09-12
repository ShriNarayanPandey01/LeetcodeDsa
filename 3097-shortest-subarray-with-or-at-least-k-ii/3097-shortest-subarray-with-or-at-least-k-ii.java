class Solution {
    public int binToInt(int[] arr){
        int a = 0;
        for( int i = 31 ; i>= 0 ; i--){
            if( arr[i] > 0)
                a += (int)Math.pow(2 , 31-i);
        }
        return a;
    }
    public void or( int[] bin , int a){
        int i = bin.length-1;
        while( a > 0){
            if( a%2 != 0)
                bin[i] += 1;
            a = a/2;
            i--;
        }
        // for( int j : bin)
        //     System.out.print(j+" ");
        // System.out.println();
     
    }
    public void nor( int[] bin , int a){
        int i = bin.length-1;
        while( a > 0){
            if( a%2 != 0)
                bin[i] -= 1;
            a = a/2;
            i--;
        }
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bin = new int[32];
        int a = 0 , b = 0;
        int m = 1000000;
        while( b < nums.length){
            or( bin , nums[b]);
            int res = binToInt(bin);
            // System.out.println( res );
            if( res >= k){
                while( a <= b && res >= k){
                    m = Math.min(m , b-a+1);
                    nor( bin , nums[a]);
                    a++;
                    res = binToInt(bin);
                }
            }
            b++;

        }
        if( m ==1000000 ) return -1;
        return m;
    }
}