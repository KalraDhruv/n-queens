import java.util.Scanner;

public class nQueen {
    public static void main(String[] args){
        System.out.print("Type the number of squares on the board: ");
        Scanner scanner = new Scanner(System.in);
        int squares = scanner.nextInt();
        int[][] board = boardCreation(squares);

    }

    /** Here 2 invariants are used that are:
     *  1. The empty spaces are going to be represented by 0.
     *  2. The spaces where a queen is present would be represented by 1.
     * @param board
     */
    public static void boardRepresentation(int[][] board){
       for(int i=0;i<board.length;i++){
           System.out.print("{ ");
           for(int j=0;j<board.length;j++){
               if(board[i][j]==1){
                   System.out.print("Q ");
               }else{
                   System.out.print("- ");
               }
           }
           System.out.print(" }");
       }
    }

    /** This method creates a board with all values initialized to 0.
     * @param n
     * @return
     */
    public static int[][] boardCreation(int n){
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]= 0;
            }
        }
        return board;
    }

    /** A recursive way to search for the solution of the n-queen problem.
     * @param board
     * @return
     */
    public static void recursiveNQueen(int[][] board){

    }

    /** A function to check whether the current square is safe for placing the queen
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static boolean queenSafeSquare(int[][] board,int x,int y){
        // Row condition Verify
        for(int j=0;j<board.length;j++){
           if(board[x][j]==1){
               return false;
           }
        }
        // Column condition Verify
        for(int i=0;i<board.length;i++){
            if(board[x][i]==1){
                return false;
            }
        }
        // Diagonal condition Verify
        // For Diagonals the slope is equals to either 1 or -1.
        for(int i=0;i<board.length;i++){
           for(int j=0;j<board.length;j++){

           }
        }

        return true;
    }
    /** Method to check the complete condition of the problem*/
    public static boolean completeCondition(int[][] board){
        int countQueens=0;
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board.length;j++){
               if(board[i][j]==1){
                  countQueens++;
               }
           }
       }
       if(countQueens==8){
           return true;
       }
       return false;
    }

}
