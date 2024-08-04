class Solution {
    int ret[];
    public int[] timeTaken(int[][] edges) {
        ret = new int[edges.length+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=edges.length;i++) adj.add(new ArrayList<>());
        int ind=0,m=0;
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            if(adj.get(edges[i][0]).size()>m){
            ind=edges[i][0];
            m=adj.get(edges[i][0]).size();
            }
            if(adj.get(edges[i][1]).size()>m){
            ind=edges[i][1];
            m=adj.get(edges[i][1]).size();
            }
        }
        boolean[] vis1 = new boolean[edges.length+1];
        boolean[] vis2 = new boolean[edges.length+1];
        vis1[ind]=true;
        hlpLeft(adj,ind,0,vis1);
        vis2[ind]=true;
        hlpRight(adj,ind,0,vis2);
        return ret;
    }
    public int hlpLeft(List<List<Integer>> adj , int src , int prevTime, boolean[] vis){
        int m = 0;
        for(int i=0;i<adj.get(src).size();i++){
            int nxt = adj.get(src).get(i);
            if(vis[nxt]) continue;
            vis[nxt]=true;
            int n = hlpLeft( adj , nxt , src%2==0 ? prevTime+2 : prevTime+1 , vis );
            m=Math.max(m,n);
            prevTime = Math.max(prevTime,n);
        }
        ret[src]=Math.max(ret[src],prevTime);
        if( src%2 == 0 ) return m+2;
        else return m+1;
    }
    public int hlpRight(List<List<Integer>> adj , int src , int prevTime, boolean[] vis){
        int m = 0;
        for(int i=adj.get(src).size()-1;i>=0;i--){
            int nxt = adj.get(src).get(i);
            // System.out.println(m+" "+nxt);
            if(vis[nxt]) continue;
            vis[nxt]=true;
            int n = hlpLeft( adj , nxt , src%2==0 ? prevTime+2 : prevTime+1 , vis );
            m=Math.max(m,n);
            prevTime = Math.max(prevTime,n);
        }
        ret[src]=Math.max(ret[src],prevTime);
        if( src%2 == 0 ) return m+2;
        else return m+1;
    }
}