public class ConnectNodesAtSameLevel {
    public void connect(Node root)
    {
        // Your code goes here.
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
    
        while(queue.size() != 0) {
            int size = queue.size();
            while(size-- > 0) {
                Node rnode = queue.removeFirst();
               
                rnode.nextRight = size != 0 ? queue.getFirst() : null;
                   
                if(rnode.left != null)
                    queue.addLast(rnode.left);
                if(rnode.right != null)
                    queue.addLast(rnode.right);
            }
        }
    }
}
