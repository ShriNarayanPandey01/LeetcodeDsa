class Solution {
    int[] arr ;
    int arrInd;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for( int i = 0 ; i< numCourses ; i++) graph.add( new ArrayList<>());
        int[] in = new int[numCourses];
        for( int[] i : prerequisites){
            graph.get(i[0]).add(i[1]);
            in[i[1]]++;
        }

        arr = new int[numCourses];
        arrInd = numCourses-1;
        for( int i = 0 ; i < numCourses ; i++){
            if( in[i] == 0 ){
                arr[arrInd--] = i;
                if(!help(graph , i , in ))
                    return new int[]{};
            }
        }
        if( arrInd != -1) return new int[]{};
        return arr;
    }
    public boolean help(ArrayList<ArrayList<Integer>> graph , int ind , int[] in ){
        
        for( int i : graph.get(ind)){
            if( in[i] == 0  ) return false;
            if( --in[i] == 0){
                in[i]--;
                arr[arrInd--] = i;
                if(!help(graph , i , in ))
                    return false;
            }           
        }

        return true;
    }
}