
/**
 * This class contains the underlying logic and flow of the game
 */
public class Game {

    //create objects from the Board and Move classes
    Board connectBoard = new Board();
    Move connectMove = new Move();

    private Player player1;
    private Player computer;

    public Game(){
        //instantiate computer and player 1
        player1 = new Player("r");
        computer = new Player("y");
        playGame();
    }

    private void playGame(){

        //intro message
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("Welcome to Connect 4");
        System.out.println("********************************************************************");
        System.out.println();
        System.out.println("There are 2 players, red and yellow");
        System.out.println("You are Player 1 and are Red and the computer player is Yellow");
        System.out.println();
        System.out.println("To play the game, type in the number of the column you want to drop your counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("If you try to place a counter in a full column, you forfeit your go :(");
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println();
        System.out.println("Player one insert disc");
        System.out.println();
        System.out.println(connectBoard.printBoard());
      
        boolean win = false;
        while(!win) {
            //try catch block to ensure correct input
            try {

                // player 1
                String userInput = connectMove.getUserInput();
                int move = Integer.parseInt(userInput) - 1;
                connectBoard.placeCounter(player1, move);
                boolean hasWon = false;
                int count = 0;
                hasWon = connectBoard.checkRedHasWon(player1.getToken(), count, hasWon);
                connectBoard.printBoard();
                System.out.println(connectBoard.printBoard());
                if (hasWon) {
                    win = true;
                    System.out.println("********************************************************************");
                    System.out.println("Red team Has Won!!!");
                    System.out.println("********************************************************************");
                }
                else {
                    System.out.println("Player 2 insert disc");

                    //computer
                    double tempCompMove = connectMove.getComputerMove();
                    int compMove = (int) tempCompMove;
                    connectBoard.placeCounter(computer, compMove);
                    hasWon = false;
                    count = 0;
                    hasWon = connectBoard.checkYellowHasWon(computer.getToken(), count, hasWon);
                    System.out.println(connectBoard.printBoard());
                    if (hasWon) {
                        win = true;
                        System.out.println("********************************************************************");
                        System.out.println("Yellow team has Won!!!");
                        System.out.println("********************************************************************");
                    }
                    else {
                        System.out.println("Player 1 insert disc");
                    }
                }
            }catch (Exception e) {
                System.out.println("Please type in a valid number");
            }
        }
    }

}