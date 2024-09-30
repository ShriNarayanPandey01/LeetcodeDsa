class MyCalendar {
    List<int[]> map;
    public MyCalendar() {
        map = new ArrayList<>();
        map.add(new int[]{-1,-1});
        map.add(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE});
    }

    
    
    public boolean book(int start, int end) {
        for (int i = 1; i < map.size() ; i++){
            if( start > map.get(i-1)[1] && end <= map.get(i)[0] ){
                map.add(i,new int[]{start ,  end -1});
                // System.out.println("1");
                // System.out.println(map.get(i)[0] +" "+ map.get(i)[1]);
                return true;
            }
        }
        if(map.get(map.size()-2)[1] < start){
            map.add(map.size()-2 , new int[]{start , end -1});
            return true;
        }
        // System.out.println(map); 
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */