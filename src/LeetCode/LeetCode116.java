package LeetCode;

import java.util.HashMap;

/**
 * 116. Populating Next Right Pointers in Each Node
 * URL: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public  class LeetCode116 {

    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    
    public Node connect(Node root) {
        connect(root,0);
        
        return root;
    }
    
    public void connect(Node root, int level) {
        if(root == null){
            return;
        }
        
       
        connect(root.right,level+1);
        
        // Process
        if(map.get(level) == null){
            map.put(level,root);
        } else {
            
            root.next = (Node) map.get(level);
            map.put(level,root);
        }
        
        connect(root.left,level+1);
        
    }
}