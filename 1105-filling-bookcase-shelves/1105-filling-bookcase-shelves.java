class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        globalWidth=shelfWidth;
        dp = new int[books.length+1];
        return hlp(books,0,shelfWidth);
    }
    int globalWidth;
    int dp[];
    public int hlp(int[][] book,int ind,int w){
        if(ind == book.length ) return 0;
        if(dp[ind]>0) return dp[ind];
        int max=Integer.MAX_VALUE;
        int maxh = -1;
        int width = 0;
        for(int i=ind;i<book.length;i++){
            if(width+book[i][0]>w)
            break;
            maxh = Math.max(maxh,book[i][1]);
            width+=book[i][0];
            max = Math.min(max , maxh+hlp(book,i+1,w));
        }
        dp[ind]= max;
        return max;
    }
}