import java.util.Arrays;

public class UnitAreaOfLargestRegion1 {
    
    public static int findMaxArea(int[][] grid) {
       int result=0;
       for(int i=0;i<grid.length;i++) {
           for(int j=0;j<grid[0].length;j++) {
               if(grid[i][j] == 1) {
                   int num = search(i,j,grid);
                   result = result > num ? result : num;
               }
           }
       }
       return result;
   }

   public static int search(int i,int j, int[][]grid) {
       if(i < 0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 ) 
           return 0;
       
       grid[i][j] = 0;
       int sum = 0;
       sum += search(i+1,j,grid);
       sum += search(i,j+1,grid);
       sum += search(i,j-1,grid);
       sum += search(i-1,j,grid);
       
       sum += search(i+1,j+1,grid);
       sum += search(i-1,j-1,grid);
       sum += search(i+1,j-1,grid);
       sum += search(i-1,j+1,grid);
       return sum + 1;
   }

   public static void main(String[] args) {
       int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};
       System.out.println(findMaxArea(grid));
   }
}
