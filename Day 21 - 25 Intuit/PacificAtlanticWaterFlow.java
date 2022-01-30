public class PacificAtlanticWaterFlow {
    private int[][] dirs = new int[][] { {-1,0}, {0,1}, {0,-1}, {1,0} };
    private int[][] g;
    private Set<Cell> pCells = new HashSet<>();
    private Set<Cell> aCells = new HashSet<>();
    private int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.g = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        
        for (int i = 0; i < m; i++) {
            dfs(new Cell(i,0, g[i][0]), aCells);
            dfs(new Cell(i,n-1, g[i][n-1]), pCells);    
        }
        
        for (int j = 0; j < n; j++) {
            dfs(new Cell(0,j, g[0][j]), aCells);
            dfs(new Cell(m-1,j, g[m-1][j]), pCells);
        }
        
        pCells.retainAll(aCells); 
        return pCells.stream().collect(Collectors.mapping(c -> List.of(c.x, c.y), Collectors.toList()));
    }
    
    private void dfs(Cell cell, Set<Cell> ocean) {
        ocean.add(cell);
        
        for (int[] dir: dirs) {
            int r = cell.x + dir[0], c = cell.y + dir[1]; 
            if (r < 0 || c < 0 || r >= m || c >= n) continue;

            var neighbor = new Cell(r, c, g[r][c]);
            if (ocean.contains(neighbor)) continue;
            if (neighbor.h >= cell.h) dfs(neighbor,ocean);
        }
    }
    
    private static class Cell {
        int x, y, h;
        Cell(int x, int y, int h) {
            this.x = x; this.y = y; this.h = h;
        }
        
       @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y && h == cell.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, h);
        }        
    }
}
