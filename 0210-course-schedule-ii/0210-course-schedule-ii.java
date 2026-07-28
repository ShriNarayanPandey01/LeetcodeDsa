class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for( int i = 0 ; i< numCourses ; i++) graph.add( new ArrayList<>());
        int[] in = new int[numCourses];
        for( int[] i : prerequisites){
            graph.get(i[0]).add(i[1]);
            in[i[1]]++;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        for( int i = 0 ; i < numCourses ; i++){
            if( in[i] == 0 ){
                ret.add(i);
                if(!help(graph , i , in  , ret))
                    return new int[]{};
            }
        }
        int[] arr = ret.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        if( arr.length != numCourses)
            return new int[]{};
        return arr;
    }
    public boolean help(ArrayList<ArrayList<Integer>> graph , int ind , int[] in , ArrayList<Integer> ret){
        
        for( int i : graph.get(ind)){
            if( in[i] == 0  ) return false;
            if( --in[i] == 0){
                in[i]--;
                ret.add(i);
                if(!help(graph , i , in  , ret))
                    return false;
            }           
        }

        return true;
    }
}