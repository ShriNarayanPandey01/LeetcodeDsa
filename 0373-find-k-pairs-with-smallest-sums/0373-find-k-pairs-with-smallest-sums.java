class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>( new Comparator<int[]>(){
            @Override
            public int compare( int[] a , int[] b){
                return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]; 
            }
        });

        pq.offer(new int[]{0,0});
        HashSet<String> set = new HashSet<>();
        set.add("0 0"); 
        while( k-- > 0 ){
            int[] a = pq.poll();
            List<Integer> r = new LinkedList<>();
            r.add(nums1[a[0]]);
            r.add(nums2[a[1]]);
            ret.add( r );

            if( a[0] + 1 < nums1.length && !set.contains((a[0]+1)+" "+a[1])){
                set.add((a[0]+1)+" "+a[1]);
                pq.offer(new int[]{a[0]+1 , a[1]});
            }
            if( a[1] + 1 < nums2.length && !set.contains((a[0])+" "+(a[1]+1))){
                set.add((a[0])+" "+(a[1]+1));
                pq.offer(new int[]{a[0] , a[1]+1});

            }

        }
        
        return ret;

    }
}