public class BracketsInMatrixMultiplication {
    static char name;
    
    static String matrixChainOrder(int p[], int n){
        // code here
        int[][] m = new int[n][n];
        int[][] bracket = new int[n][n];
        
        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++)  {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        name = 'A';
        String res = "";
        res += parenthesis(1, n - 1, n, bracket);
        return res;
    }
    
    
    static String parenthesis(int i, int j, int n, int[][] bracket) {
        if (i == j) {
            return Character.toString(name++);
        }
        return ('(' + parenthesis(i, bracket[i][j], n, bracket) + parenthesis(bracket[i][j] + 1, j, n, bracket) + ')');
    }

    public static void main(String[] args) {
        System.out.println(matrixChainOrder(new int[]{1, 2, 3, 4, 5}, 5));
    }
}