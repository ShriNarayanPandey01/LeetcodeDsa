/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode , Integer> map = new HashMap<>();
    int leftMin = 0 , rightMax = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root , 0);
        List<List<Integer>> ret = new LinkedList<>();
        for( int i = 0 ; i <= (rightMax - leftMin) ; i++)
            ret.add( new LinkedList<>());

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // System.out.println(leftMin+" "+rightMax);
        while( q.size() > 0){
            int i = q.size();
            PriorityQueue<TreeNode> pq = new PriorityQueue<>( new Comparator<TreeNode>(){
                @Override
                public int compare( TreeNode a , TreeNode b){
                    if( map.get(a) == map.get(b))
                        return a.val - b.val;
                    return map.get(a) - map.get(b);
                }
            });
            while(i-->0){
                TreeNode p = q.poll();
                
                pq.offer(p);
                if( p.left != null)
                    q.offer(p.left);
                if( p.right != null)
                    q.offer(p.right);  
            }
            while(pq.size() > 0){
                TreeNode p = pq.poll();
                ret.get(map.get(p)-leftMin).add(p.val);
            }
        }
        return ret;

    }
    public void dfs(TreeNode root , int place  ){
        if( root == null) return;
        map.put(root , place);
        leftMin = Math.min(leftMin , place);
        rightMax = Math.max(rightMax , place);
        dfs( root.left , place-1);
        dfs( root.right , place+1);
    }
}