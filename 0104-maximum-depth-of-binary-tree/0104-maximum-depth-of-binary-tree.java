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
    public int maxDepth(TreeNode root) {
       List<TreeNode> q= new LinkedList<>();
    List<TreeNode> nxt= new LinkedList<>();
  
    if(root==null)
    return 0;
    int count=0;
    q.add(root);
    while(q.size()>0){
        count++;
     
        while(q.size()>0){
            TreeNode itr=q.get(0);
            
            q.remove(0);
            if(itr.left!=null)
            nxt.add(itr.left);
            if(itr.right!=null)
            nxt.add(itr.right);   
        }
        
        q.addAll(nxt);
        nxt.clear();
    }
    return count;
    }
   
}