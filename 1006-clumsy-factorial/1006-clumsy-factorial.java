class Solution {
    public int calculate( String c , int a , int b){


        if( c.equals("+"))
            return a + b;
        else if ( c.equals("-"))
            return a - b;
        else if ( c.equals("/"))
            return a/b;
        return a*b;
    }
    public int clumsy(int n) {
        Queue<String> q = new LinkedList<>();
        Deque<String> st = new ArrayDeque<>();
        q.offer("*");
        q.offer("/");
        q.offer("+");
        q.offer("-");
        st.push(n+"");
        for( int i = n-1 ; i>= 1 ; i--){
            String c = q.poll();
            if( c == "*" || c == "/"){
                st.addLast( calculate( c , Integer.parseInt(st.removeLast()) , i) + "");
            }
            else{
                st.addLast(c+"");
                st.addLast(i+"");
            }
            q.offer(c);
        }
        while( st.size() > 1){
            int k = Integer.parseInt( st.removeFirst());
            st.push( ""+calculate(st.pop() , k  ,Integer.parseInt(st.removeFirst()) ));
        }
        return Integer.parseInt(st.peek()) ;
    }
}