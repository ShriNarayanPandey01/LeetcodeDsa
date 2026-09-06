class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<>(){
            @Override
            public int compare(int[] a , int[] b){
                return  b[1] - a[1];
            } 
        });
        for( int[] i : stations)
            pq.offer(i);
        
        while(startFuel < target){
            PriorityQueue<int[]> temp  =  new PriorityQueue<>( new Comparator<>(){
                @Override
                public int compare(int[] a , int[] b){
                    return  b[1] - a[1];
                } 
                });
            while( pq.size() > 0 && pq.peek()[0] > startFuel)
                temp.add(pq.poll());

            if( pq.size() == 0)
                break;
            else
                startFuel += pq.poll()[1];

            pq.addAll(temp); 
        }

        if( startFuel <  target )
            return -1;
        else 
            return stations.length - pq.size();
    }
}