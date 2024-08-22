class LockingTree {
    int[] lock ;
    int[] tree ;
    List<List<Integer>> adj = new ArrayList<>();
    public LockingTree(int[] parent) {
        lock = new int[parent.length];
        this.tree = parent;
        for(int i=0;i<parent.length;i++) adj.add(new ArrayList<>());
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1)continue;
            else 
            adj.get(parent[i]).add(i);
        }
    }
    public boolean ansestor(int node){
        if(lock[0]>0) return false;
        int src = node;
        while(tree[src]!=-1){
            if(lock[src]>0) return false;
            src = tree[src];
        }
        return true;
    }
    public boolean descendent(int node){
        if(adj.get(node).size()==0)
        if(lock[node]>0) return true;
        else return false;

        boolean ret = false;
        if(lock[node]>0) ret = true;
        for(int i=0;i<adj.get(node).size();i++){
            ret = ret || descendent(adj.get(node).get(i));
        }
        return ret;
        
    }
    public boolean lock(int num, int user) {
       if(lock[num]>0) return false;
       lock[num] = user;
       return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num]==user){
            lock[num]=0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        System.out.println(num);
         
         if(ansestor(num) && lock[num]==0){
            if(adj.get(num).size()==0)
            if(lock[num]>0) return true;
            else return false;
            boolean ret = false;
            for(int i=0;i<adj.get(num).size();i++)
            ret = ret || descendent(adj.get(num).get(i));
            
            if(!ret) return false;
            unlock(num);
            lock[num]=user;
            return true;
        }
        return false;
    }
    public void unlock(int nums){
        lock[nums]=0;
        if(adj.get(nums).size()==0) return ;
        
        for(int i=0;i<adj.get(nums).size();i++)
        unlock(adj.get(nums).get(i));
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */