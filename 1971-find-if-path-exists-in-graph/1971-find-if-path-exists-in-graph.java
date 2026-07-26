class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for( int i = 0 ; i < n ; i++)
            graph.add(new ArrayList<>());
        
        for( int[] i : edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean[] visi = new boolean[n];
        Queue<Integer> q  = new LinkedList<>();
        if( source == destination ) return true;
        q.offer(source);
        visi[source] = true;
        while( q.size() > 0 ){
            Queue<Integer> nq = new LinkedList<>();
            while(q.size() > 0){
                int p = q.poll();
                for(int i : graph.get(p)){
                    if( i == destination ) return true;
                    if( visi[i]) continue;
                    visi[i] = true;
                    nq.offer(i);
                }
            }
            q = nq;
        }
        return false;
    }
}