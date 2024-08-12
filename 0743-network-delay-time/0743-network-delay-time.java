class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj = new int[n][n];
        for (int[] row : adj) {
            Arrays.fill(row, -1); // Initialize with a large value representing infinity
        }
        int[] time = new int[n];
        Arrays.fill(time,10000000);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int i = 0 ; i < times.length ; i ++){
            adj[times[i][0] - 1][times[i][1] -1] = times[i][2];
        }
        boolean[] vis = new boolean[n];
        time[k - 1] = 0;
        q.add(new int[] {0 , k - 1});
        while(q.size()>0){
            int[] pop = q.poll();
            int cost = pop[0];
            int src = pop[1];
            if(vis[src]) continue;
            vis[src] = true;
            time[src] = cost;
            for(int i = 0 ; i < n ; i ++){
                if(adj[src][i] > -1){
                    if(time[i] > cost + adj[src][i]){
                        time[i] = cost + adj[src][i];
                        q.offer(new int[]{time[i] ,i});
                    }
                }
            }
        }
        int max = -1;
        for(int i : time){
            if(i == 10000000) return -1;
            max = Math.max(max , i);
        }
        return max;
    }
}