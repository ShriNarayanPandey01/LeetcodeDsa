class Solution {
    public int lengthLongestPath(String input) {
        Stack<int[]> st = new Stack<>();
        String[] dir = input.split("\n");
        
        int max = 0;
        int currSize = 0;
        for( String s : dir){
            
            String[] temp = s.split("\t");
            int depth = temp.length-1;
            int dirSize = temp[temp.length-1].length();
            // System.out.println(s + " "+temp[temp.length-1]+" "+temp.length);
            if( st.size() == 0 || st.peek()[0] < depth){
                currSize += dirSize;
                if(temp[temp.length-1].contains("."))
                max = Math.max(currSize + depth, max);
                // System.out.println(s + " "+temp[temp.length-1]+" "+temp.length+" "+temp[temp.length-1].length()+" "+currSize);
                st.push(new int[]{depth , dirSize});
            }
            else{
                while(st.size() > 0 && st.peek()[0] >= depth){
                    currSize -= st.pop()[1];
                }
                currSize += dirSize;
                // System.out.println(s + "-"+temp[temp.length-1]+" "+temp.length+" "+temp[temp.length-1].length()+" "+currSize);
                if(temp[temp.length-1].contains("."))
                    max = Math.max(currSize + depth, max);
                st.push(new int[]{depth , dirSize}); 
            }
        }
        return max;
    }
}