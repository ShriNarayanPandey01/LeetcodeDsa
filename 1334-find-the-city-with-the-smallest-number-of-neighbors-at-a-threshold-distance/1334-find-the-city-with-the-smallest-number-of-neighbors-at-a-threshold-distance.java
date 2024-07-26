class Solution {
    public int findTheCity(int n, int[][] edges, int k) {
        List<List<int[]>> adj = new LinkedList<>();
        for(int i=0;i<n;i++) adj.add(new LinkedList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        int src = 0;
        int countm= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            int[] ret = dijkstra(adj,i);
            // for(int j:ret)
            // System.out.print(j+" ");
            
            for(int j:ret)
                if(j>0 && j<=k)
                  count++;
            // System.out.println(count);    
            if(count!=0 && count<=countm){
                countm=count;
                src=i;
            }
        }
        return src;
        
    }
    public int[] dijkstra(List<List<int[]>> adj,int src){
       int[] ret = new int[adj.size()];
       Arrays.fill(ret,Integer.MAX_VALUE);
       PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a,int[] b){
            return Integer.compare(a[1],b[1]);
        }
       });

       boolean[] vis = new boolean[adj.size()];
       pq.offer(new int[]{src,0});
       while(pq.size()>0){
        int[] p = pq.poll();
        if(vis[p[0]])
        continue;
        vis[p[0]]=true;
        ret[p[0]]=(p[1]);
        for(int i=0;i<adj.get(p[0]).size();i++){
            int[] arr = adj.get(p[0]).get(i);
            if(ret[arr[0]]>arr[1]+p[1]){
                pq.offer(new int[]{arr[0],arr[1]+p[1]});
            }
        }
       }
       return ret;
    }

}