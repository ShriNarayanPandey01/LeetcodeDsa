class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s : dir){
            if( s.equals("") || s.equals("."))
                continue;
            if( s.equals("..")){
                if(st.size()>0)
                    System.out.println(st.pop());
            }
            else{
                st.push(s);
            }
        }
        if( st.size() == 0) return "/";
        String ret = "";
        while(st.size() > 0 ){
            ret = "/"+st.pop()+ret;
        }
        return ret;

    }
}