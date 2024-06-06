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

}
