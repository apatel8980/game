
/**
 * Board Class contains the attributes, data structures and methods for printed the board,
 * placing counter, and checking winners
 */

public class Board {

    private final int rows = 6;
    private final int columns = 7;
    private String[][] board;

    private final int winningNumber = 4;

    public Board() {
       this.board = new String[rows][columns];
    }
    public String printBoard(){
        String str = "";

        for(int i=0; i< rows; i++){
            for(int j=0; j< columns; j++){
                if(board[i][j] == "r"){
                    str+="| r ";
                }
                else if(board[i][j] == "y"){
                    str+="| y ";
                }
                else{
                    str+="|   ";
                }
            }
            str+="|";
            str+=" \n";
        }
        str+="  1   2   3   4   5   6   7";
        return str;
    }

    public void placeCounter(Player player, int position){
        boolean placed = false;
        if( player.getToken() == "r"){
            for(int i= rows-1; i>=0; i--) {
                if(!placed){
                    if(board[i][position] == "y"){
                        // skip
                    } else if(this.board[i][position] != "r"){
                        board[i][position] = player.getToken();
                        placed = true;
                    }
                }
            }
        } else{
            for(int i= rows-1; i>=0; i--) {
                if(!placed){
                    if(board[i][position]== "r"){
                        // skip
                    } else if(this.board[i][position] != "y"){
                        board[i][position] = player.getToken();
                        placed = true;
                    }
                }
            }
        }
    }

    public boolean checkRedHasWon(String r, int count, boolean hasWon) {
        // check horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == "r") {
                    count++;
                    if (count == winningNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        // check vertical
        count = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == "r") {
                    count++;
                    if (count == winningNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }//upward diagonal
        for(int row = 3; row < rows; row++){
            for(int col = 0; col < columns-3; col++) {
                if (board[row][col] == "r" &&
                        board[row - 1][col + 1] == "r" &&
                        board[row - 2][col + 2] == "r" &&
                        board[row - 3][col + 3] == "r")
                {
                    hasWon = true;
                }
            }
        }//downward diagonal
        for(int row = 3; row < rows - 3; row++){
            for(int col = 0; col < columns - 3; col++){
                if (board[row][col] == "r"   &&
                        board[row+1][col+1] == "r" &&
                        board[row+2][col+2] == "r" &&
                        board[row+3][col+3] == "r") {
                    hasWon = true;
                }
            }
        }
        return hasWon;
    }

    public boolean checkYellowHasWon(String y, int count, boolean hasWon) {
        // check horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == "y") {
                    count++;
                    if (count >= winningNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        // check vertical
        count = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == "y") {
                    count++;
                    if (count >= winningNumber) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        //upward diag
        for(int row = 3; row < rows; row++){
            for(int col = 0; col < columns-3; col++) {
                if (board[row][col] == "y" &&
                        board[row - 1][col + 1] == "y" &&
                        board[row - 2][col + 2] == "y" &&
                        board[row - 3][col + 3] == "y")
                {
                    hasWon = true;
                }
            }
        }
        //downward diag
        for(int row = 3; row < rows - 3; row++){
            for(int col = 0; col < columns - 3; col++){
                if (board[row][col] == "y"   &&
                        board[row+1][col+1] == "y" &&
                        board[row+2][col+2] == "y" &&
                        board[row+3][col+3] == "y") {
                    hasWon = true;
                }
            }
        }

        return hasWon;
    }
}
