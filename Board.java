//You are supposed to add your comments

import java.util.*;

//This class holds the data for a point
class Point {

    int x, y;

   //The x and y coordinates are taken as parameters for the constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}

// This class is responsible for storing the points and scores
class PointsAndScores {
    int score; // the score to store.
    Point point; // the point to store.

    PointsAndScores(int score, Point point) {
        this.score = score;
        this.point = point;
    }
}

//This class is responsible for storing the board and functions relating to the board.

class Board {

    // The list of empty spaces on the board.
    List<Point> availablePoints;

     // The scanner to scan the users input
    Scanner scan = new Scanner(System.in);

     // The board of the game.
    int[][] board = new int[5][5];

    public Board() {
    }


     // This method returns whether the game is over or not.
    public boolean isGameOver() {
        return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty());
    }


     // This method checks whether x has won or not, it returns boolean accordingly.

    public boolean hasXWon() {

        // Checking for diagonal matching.
        if((board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1 && board[4][4] == 1) ||
                (board[0][4] == 1 && board[1][3] == 1 && board[2][2] == 1 && board[3][1] == 1 && board[4][0] == 1)) {
            return true;
        }

        // Checking for horizontal and vertical matching.
        for (int i = 0; i < board.length; ++i) {
            boolean isX = true;
            for(int x = 0; x<board.length; x++) {
                if(board[i][x] != 1) {
                    isX = false;
                }
            }
            if(isX) return true;
            isX = true;
            for(int y = 0; y<board.length; y++) {
                if(board[y][i] != 1) {
                    isX = false;
                }
            }

            if(isX) return true;
        }
        return false;
    }


     //This method checks whether 0 has won or not, it returns a boolean value accordingly
    public boolean hasOWon() {

        // Checking for diagonal matching.
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == board[3][3] && board[0][0] == board[4][4] && board[0][0] == 2) ||
                (board[0][4] == board[1][3] && board[0][4] == board[2][2] && board[0][4] == board[3][1] && board[0][4] == board[4][0] && board[0][4] == 2)) {
            return true;
        }

        // Checking for horizontal and vertical pairing.
        for (int i = 0; i < board.length; i++) {
            boolean isO = true;
            for(int x = 0; x<board.length; x++) {
                if(board[i][x] != 2) {
                    isO = false;
                }
            }
            if(isO) return true;
            isO = true;
            for(int y = 0; y<board.length; y++) {
                if(board[y][i] != 2) {
                    isO = false;
                }
            }

            if(isO) return true;
        }
        return false;
    }



     // This method returns the empty points in the board, the list of empty points on the board.

    public List<Point> getAvailablePoints() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    /*
      This method returns the state of a given point.
     Parameter point is the point whose state is to be returned.
     */
    public int getState(Point point){
        return board[point.x][point.y];
    }



    /*This method places a given move on the board.
     The parameter point the point at which the move is to be made.
     and the parameter player is the player who is making the move.
     */
    public void placeAMove(Point point, int player) {
        board[point.x][point.y] = player;
    }


     //This method displays the board on the console.
    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j]==1)
                    System.out.print("X ");
                else if (board[i][j]==2)
                    System.out.print("O ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}
