/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node root = new Node();
        HashMap<Node , Node> vis = new HashMap<>();
        return clone(node , root , vis);
    }
    public Node clone(Node node , Node root , HashMap<Node , Node> vis){
        if (node == null) return null;
        root.val = node.val;
        vis.put(node , root);
        for( Node n : node.neighbors){
            
            Node cp = new Node();
            if( vis.containsKey(n)) 
                root.neighbors.add(vis.get(n));
            else
                root.neighbors.add(clone(n , cp, vis));
        }
        return root;
    }
}