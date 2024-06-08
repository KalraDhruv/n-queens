import java.util.Scanner;

public class nQueen {
    public static void main(String[] args){
        System.out.print("Type the number of squares on the board: ");
        Scanner scanner = new Scanner(System.in);
        int squares = scanner.nextInt();
        int[][] board = boardCreation(squares);
        recursiveNQueen(board,0,0);
        boardRepresentation(board);

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
           System.out.println("}");
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
     *  Here x and y are two coordinates which are used to pass the position
     *  to the recursive call.
     * @param board
     * @return
     */
    public static int recursiveNQueen(int[][] board,int x,int y){
        // Base case
        if(completeCondition(board)){
            System.out.println("Solution Obtained!");
            return 0;
        }

        // Checking the safety of the square
      if(queenSafeSquare(board,x,y)){
          // Inserting the queen if safe
         board[x][y]=1;
      }

      // Recursive Call on next element.
      if(y<board.length-1){
          return recursiveNQueen(board,x,++y);
      } else{
          // Handling Backtracking in case of no solution.
          boolean conditionBacktrack=true;
          for(int i=0;i<board.length;i++){
              if(board[x][i]==1){
                 conditionBacktrack = false;
              }
          }
          if(conditionBacktrack){
             for(int i=0;i<board.length;i++){
                 if(board[x-1][i]==1){
                     board[x-1][i]=0;
                     if(i+1<board.length){
                        return recursiveNQueen(board,x-1,i+1);
                     }
                 }
             }
             for(int i=0;i<board.length;i++){
                 if(x-2<0){
                     System.out.println("Solution Not Found!");
                     return -1;
                 }
                 if(board[x-2][i]==1){
                     board[x-2][i]=0;
                     return recursiveNQueen(board,x-2,i+1);
                 }
             }
          }else{
              return recursiveNQueen(board,++x,0);
          }
      }
      return -1;
    }

    /** A function to check whether the current square is safe for placing the queen
     * The Inputs for x and y must be of the form {0,....,n}
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
            if(board[i][y]==1){
                return false;
            }
        }
        // Diagonal condition Verify
        // For Diagonals the slope is equals to either 1 or -1.
        for(int i=0;i<board.length;i++){
           for(int j=0;j<board.length;j++){
               int yResult = Math.abs(y-j);
               int xResult = Math.abs(x-i);
               if(xResult ==0){
                   continue;
               }
               int slope = yResult/xResult;
               if(slope == 1 && yResult%xResult==0){
                   if(board[i][j]==1){
                      return false;
                   }
               }
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
       if(countQueens==board.length){
           return true;
       }
       return false;
    }

}
