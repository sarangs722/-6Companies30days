public class DeleteNNodeAfter {
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node curr = head, t; 
        int count; 

        while (curr!=null) { 
            for (count = 1; count < M && curr != null; count++) 
                curr = curr.next; 
    
            if (curr == null) 
                return; 

            t = curr.next; 
            for (count = 1; count <= N && t != null; count++) { 
                Node temp = t; 
                t = t.next; 
            } 
            
            curr.next = t; 
    
            curr = t; 
        } 
    }
}
