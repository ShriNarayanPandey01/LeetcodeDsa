class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        HashSet<Integer> vis = new HashSet<>();

        
        Queue<Integer> q = new LinkedList<>();
        for( int j = 0 ; j < graph.length ; j++){
        if( vis.contains(j)) continue;
        q.offer(j);
        b.add(j);
        vis.add(j);
        boolean isA = false;
        while( q.size() > 0){
            int n = q.size();
            while(n-- > 0){
                int node = q.poll();
                for( int i : graph[node]){
                    if( isA )
                        if( a.contains(i))
                            return false;
                        else
                            b.add(i);
                    else
                        if( b.contains(i))
                            return false;
                        else
                            a.add(i);
                    if( vis.contains(i)) continue;
                    vis.add(i);
                    q.add(i);
                }
                
            }
            isA = !isA;
        }
        }
        return true;

    }
}