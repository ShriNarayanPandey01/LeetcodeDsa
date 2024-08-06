class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
          HashMap<Integer,Integer> map = new HashMap<>();
          int[] ret = new  int[queries.length];
          int ind=0;
          for(int i=0;i<n-1;i++) map.put(i,i+1);
          for(int[] q : queries ){
            if(map.containsKey(q[0])){
               delete(map,q[0],q[1]);
            }
            ret[ind++]=map.size(); 
          }
          return ret;
    }
    public void delete(HashMap<Integer,Integer> map , int start , int end){
        if(map.get(start)<end){
            int itr = map.get(start);
            while(itr!=end){
                int nxt = map.get(itr);
                map.remove(itr);
                itr=nxt;
            }
            map.put(start,end);
        }
    }
}