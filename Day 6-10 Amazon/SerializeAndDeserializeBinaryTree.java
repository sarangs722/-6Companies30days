import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int x) { data = x; }
}

class Tree 
{
	class Passing{
        int index;
    }
    
	public void serialize(Node root, ArrayList<Integer> A) {
	    if(root==null){
	        A.add(-1);
	        return;
	    }   
	    A.add(root.data);
	    
	    serialize(root.left, A);
	    serialize(root.right, A);
	}
	
	public Node kewl(ArrayList<Integer> A, Passing ps) {
        if (ps.index == A.size() || A.get(ps.index) == -1) 
        {
            ps.index += 1;
            return null;
        }
        Node root = new Node(A.get(ps.index));
        ps.index += 1;
        
        root.left = kewl(A, ps);
        root.right = kewl(A, ps);
        return root;
    }

    public Node deSerialize(ArrayList<Integer> A) {
        Passing ps=new Passing();
        ps.index=0;
        return kewl(A, ps);
    }

};