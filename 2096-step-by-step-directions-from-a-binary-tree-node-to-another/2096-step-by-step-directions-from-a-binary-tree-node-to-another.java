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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode cmn = common(root,startValue,destValue);
        System.out.println(cmn.val);
        String findTrgt = target(cmn , destValue,startValue,0);
        String findSrc = src(cmn ,startValue,destValue,0 );
        // System.out.println(findTrgt);
        // System.out.println(findSrc);

        if(t){
            findTrgt.substring(ind,findSrc.length()-1);
        }
        if(s){
            return findSrc.substring(ind,findSrc.length()-1);
        }
        return findSrc.substring(0,findSrc.length()-1)+findTrgt.substring(0,findTrgt.length()-1);

    }
    boolean t=false,s=false;
    int ind=0;
    public String target(TreeNode root , int target ,int start,int lvl){
        if(root==null)
        return "";
        if(root.val==target){
            return " ";
        }
       
        String left = target(root.left,target,start,lvl+1);
        String right = target(root.right,target,start,lvl+1);
        if((left.length()>1 || right.length()>1) &&  root.val==start){
            ind=lvl;
            t=true;
        }

        if(left.length()>0) return "L"+left;
        if(right.length()>0) return "R"+right;

        return "";    
    }
    public String src(TreeNode root , int target,int start,int lvl){
        if(root==null)
        return "";
        if(root.val==target){
            return " ";
        }
        String left = src(root.left,target,start,lvl+1);
        String right = src(root.right,target,start ,lvl+1);
        if((left.length()>1 || right.length()>1) &&  root.val==start){
            ind=lvl;
            s=true;
        }

        if(left.length()>0) return "U"+left;
        if(right.length()>0) return "U"+right;

        return "";    
    }
    public TreeNode common(TreeNode root, int start , int end ){
        if(root==null){
            return null;
        }
        if(root.val==start || root.val==end)
        return root;
        TreeNode left  = common(root.left,start,end);
        TreeNode right  = common(root.right,start,end);
        if(left!=null && right!=null)
            return root;
        if(right!=null) return right;
        else if(left!=null) return left;
        return null;     
    }
}