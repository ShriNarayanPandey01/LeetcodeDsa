class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k-1] = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for( int i =0 ; i < n ; i++) graph.add( new ArrayList<>());

        for( int[] i : times){
            graph.get(i[0]-1).add( new int[]{i[1]-1,i[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b){
                return a[1] - b[1];
            }
        }); 
        
        pq.offer(new int[]{k-1,0});
        while(pq.size() > 0){
            int[] p = pq.poll();

            for(int[] arr : graph.get(p[0]) ){
                if( dist[p[0]] + arr[1] < dist[arr[0]]  ){
                    dist[arr[0]] = dist[p[0]] + arr[1];

                    pq.offer( new int[]{arr[0] ,dist[p[0]] + arr[1] });
                }
            }
        }
        int max = -1;
        for( int i : dist)
            max = Math.max(i,max);
        
        return max == Integer.MAX_VALUE ? -1 : max;


    }


}