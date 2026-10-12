class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<Integer , HashMap<Integer , Integer>> xMap = new HashMap<>();
        
        int count = 0;
        for( List<Integer> i : coordinates ){
            int x = i.get(0);
            int y = i.get(1);
            if( xMap.containsKey(x)){
                HashMap<Integer, Integer> a = xMap.get(x);
                a.put( y , a.getOrDefault(y,0)+1);
                xMap.put(x , a);
            }
            else{
                HashMap<Integer, Integer> a = new HashMap<>();
                a.put(y,1);
                xMap.put(x , a);
            }
        }
        int l = -1;
        for( List<Integer> j : coordinates ){
            l++;
            int x = j.get(0);
            int y = j.get(1);
            for( int i = 0 ; i<=k ; i++){
                int X = x^i;
                int Y = y^(k-i);
                if( xMap.containsKey(X)){
                    if( xMap.get(X).containsKey(Y))
                        if( x==X && y==Y)
                            count += xMap.get(X).get(Y)-1;
                        else
                            count += xMap.get(X).get(Y);
                }
                

            }
            HashMap<Integer,Integer> a = xMap.get(x);
            if(a.get(y) > 1)
                a.put(y , a.get(y) -1);
            else 
                a.remove(y);
            if( a.size() > 0)
                xMap.put(x,a);
            else
                xMap.remove(x);


            
        }
        return count;
    }
}