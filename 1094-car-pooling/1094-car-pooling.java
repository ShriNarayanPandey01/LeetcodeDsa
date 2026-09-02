class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips , new Comparator<int[]>(){
            @Override
            public int compare( int[] a , int[] b){
                if( a[1] == b[1])
                    return a[2] - b[2];
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>(){
            @Override
            public int compare( int[] a , int[] b){
                if( a[2] == b[2])
                    return a[1] - b[1];
                return a[2] - b[2];
            }
        });

        

        
        for( int[] i : trips ){
            while( pq.size()>0 && pq.peek()[2] <= i[1]){
                capacity += pq.poll()[0];
            }
            if( capacity >= i[0]){
                pq.offer( i );
                capacity -= i[0];
            }
            else return false;
        }
        return true;
    }
}