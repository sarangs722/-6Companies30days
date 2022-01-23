import java.util.*;

public class PrerequisiteTasks {
    static boolean res=false;

    public static boolean isPossible(int n, int[][] arr) {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int[] e:arr) {
            int u=e[1];
            int v=e[0];
            adj.get(u).add(v);
        }
        isCycle(adj,n);
        return (!res);
    }
    
    
    public static void isCycle(ArrayList<ArrayList<Integer>> adj,int v) {
        boolean[] vis=new boolean[v];
        boolean[] rec=new boolean[v];
        for(int i=0;i<v;i++) {
            if(!vis[i])
                dfs(adj,vis,rec,i);
        }
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,
        boolean[] rec,int u) {
        
        vis[u]=true;
        rec[u]=true;
        for(int v:adj.get(u)) {
            if(!vis[v]) {
                dfs(adj,vis,rec,v);
            } else {
                if(rec[v])
                    res=true;
            }
        }
        rec[u]=false;
    }

    public static void main(String[] args) {
        int n = 4, p = 3, prerequisites[][] = {{1,0},{2,1},{3,2}};
        System.out.println(isPossible(n, prerequisites));
    }
}
