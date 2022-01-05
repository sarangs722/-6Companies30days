public class SquaresInNNChessboard {
    public static Long squaresInChessBoard(long N) {
        // code here
        long squares = 0;
        while (N > 0) {
            squares += Math.pow(N, 2);
            N--;
        }
        
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(squaresInChessBoard(4));
    }
}
