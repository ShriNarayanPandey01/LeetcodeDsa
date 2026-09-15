class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(vBars);
        Arrays.sort(hBars);
        int maxh = 1;
        int a = 1 ;
        while( a < hBars.length){
            if( hBars[a] == (hBars[a-1]+1)){
                int b = a-2;
                while( a < hBars.length &&  hBars[a] == (hBars[a-1]+1) ){
                    maxh = Math.max(maxh , a-b);
                    a++;
                }
                
            }
            else{
                a++;
            }
        }
        int maxv = 1;
        a = 1 ;
        while( a < vBars.length){
            if( vBars[a] == (vBars[a-1]+1)){
                int b = a-2;
                while( a < vBars.length &&  vBars[a] == (vBars[a-1]+1) ){
                    maxv = Math.max(maxv , a-b);
                    a++;
                }
               
            }
            else{
                a++;
            }
        }
        return (int)(Math.min(maxh , maxv)+1)*(Math.min(maxh , maxv)+1);

    }
}