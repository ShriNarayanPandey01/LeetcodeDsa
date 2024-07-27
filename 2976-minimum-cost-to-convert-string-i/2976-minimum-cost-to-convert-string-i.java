class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> adj = new ArrayList<>();
        List<int[]> dist = new ArrayList<>();
        for(int i=0;i<26;i++) 
            adj.add(new ArrayList<>());   
        for(int i=0;i<original.length;i++)
            adj.get((original[i]-'a')).add(new int[]{changed[i]-'a',cost[i]});
        for(int i=0;i<26;i++)
            dist.add(findShortestPath(adj,i));
        long move=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                if(dist.get(source.charAt(i)-'a')[target.charAt(i)-'a']!=Integer.MAX_VALUE)
                move+=(long)dist.get(source.charAt(i)-'a')[target.charAt(i)-'a'];
                else return -1;
            }
        }
            
        
        return move;
    }
    public int[] findShortestPath(List<List<int[]>> adj , int src){
        int[] dist = new int[26];
        dist[src]=0;
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return Integer.compare(a[1],b[1]);
            }
        });
        boolean[] vis = new boolean[26];
        pq.offer(new int[]{src,0});
        while(pq.size()>0){
            int[] p = pq.poll();
            if(vis[p[0]])
            continue;
            vis[p[0]]=true;
            dist[p[0]]=p[1];
            for(int i=0;i<adj.get(p[0]).size();i++){
                int[] arr = adj.get(p[0]).get(i);
                if(dist[arr[0]]>p[1]+arr[1]){
                    dist[arr[0]]=p[1]+arr[1];
                    // System.out.print(arr[0]+" "+(p[1]+arr[1]));
                    pq.offer(new int[]{arr[0],p[1]+arr[1]});
                }
            }
        }
       
        return dist;
    }
}