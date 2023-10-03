//You are supposed to add your comments

import java.util.*;


// This class uses all the other classes to provide the tictactoe functionality.
public class TicTacToe {


    //This is the main class of the program.
    public static void main(String[] args) {

        // The minimax instant.
        AIplayer AI= new AIplayer();

        // The board.
        Board b = new Board();

        // The point
        Point p = new Point(0, 0);
        Random rand = new Random();

        b.displayBoard(); // Displaying the empty board.

        // Prompt to ask for the first player in the game.
        System.out.println("Who makes first move? (1)Computer (2)User: ");
        int choice = b.scan.nextInt();
        if(choice == 1){
            AI.callMinimax(0, 1, b);
            for (PointsAndScores pas : AI.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }
            b.placeAMove(AI.returnBestMove(), 1);
            b.displayBoard();
        }

        // This is the game loop.
        while (!b.isGameOver()) {
            // Prompting for move.
            System.out.println("Your move: line (1, 2, 3, 4 or 5) colunm (1, 2, 3, 4 or 5)");
            Point userMove = new Point(b.scan.nextInt()-1, b.scan.nextInt()-1);

            // If the given move by the user is not valid, the user is prompted again.
            while (b.getState(userMove)!=0) {
                System.out.println("Invalid move. Make your move again: ");
                userMove.x=b.scan.nextInt()-1;
                userMove.y=b.scan.nextInt()-1;
            }
            b.placeAMove(userMove, 2);
            b.displayBoard();

            // Ending the game if it is over.
            if (b.isGameOver()) {
                break;
            }

            // Calling the minimax algorithm for a predicted move.
            AI.callMinimax(0, 1, b);
            for (PointsAndScores pas : AI.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }
            b.placeAMove(AI.returnBestMove(), 1);
            b.displayBoard();
        }

        // If the game is over, the winner is checked and printed.
        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}