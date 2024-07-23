class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n=maxHeights.size();
        long[] l = left(maxHeights);
        long[] r = right(maxHeights);
        long max = -1;
        for(int i=0;i<maxHeights.size();i++){
            max = Math.max(max,l[i]+r[i]-maxHeights.get(i));
        }
        return max;
    }
    public long[] left(List<Integer> maxHeights){
        Stack<Pair<Long,Integer>> st = new Stack<>();
        int n = maxHeights.size();
        long[] l = new long[n];
        l[n-1]=(long)maxHeights.get(n-1);
        st.push(new Pair<>(l[n-1],n-1));
        for(int i=n-2;i>=0;i--){
            if(maxHeights.get(i)>=maxHeights.get(i+1)){
                long nextSum = st.peek().getKey()+(long)maxHeights.get(i);
                st.push(new Pair<>(nextSum,i));
                l[i]=nextSum;
            }
            else{
                while(st.size()>0 && maxHeights.get((st.peek().getValue()))>maxHeights.get(i))
                    st.pop();
                long ind = st.size()==0?n-1:st.peek().getValue();
                long ad= st.size()==0?(long)maxHeights.get(i):st.peek().getKey();
                long nextSum=ad+(ind-i)*(long)maxHeights.get(i);
                st.push(new Pair<>(nextSum,i));
                l[i]=nextSum;
            }
        }
        return l;
    }
    public long[] right(List<Integer> maxHeights){
        Stack<Pair<Long,Integer>> st = new Stack<>();
        int n = maxHeights.size();
        long[] l = new long[n];
        l[0]=(long)maxHeights.get(0);
        st.push(new Pair<>(l[0],0));
        for(int i=1;i<n;i++){
            if(maxHeights.get(i)>=maxHeights.get(i-1)){
                long nextSum = st.peek().getKey()+(long)maxHeights.get(i);
                st.push(new Pair<>(nextSum,i));
                l[i]=nextSum;
            }
            else{
                while(st.size()>0 && maxHeights.get((st.peek().getValue()))>maxHeights.get(i))
                    st.pop();
                long ind = st.size()==0?0:st.peek().getValue();
                long ad= st.size()==0?(long)maxHeights.get(i):st.peek().getKey();
                long nextSum=ad+(i-ind)*(long)maxHeights.get(i);
                st.push(new Pair<>(nextSum,i));
                l[i]=nextSum;
            }
        }
        return l;
    }
}