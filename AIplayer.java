//You are supposed to add your comments

import java.util.*;


  //This class contains the AI player and the minimax algorithm implementation.

class AIplayer {


    //The list of empty points on the board.
    List<Point> availablePoints;

    //The list of the points at which a move can be made and the evaluated score of the move.
    List<PointsAndScores> rootsChildrenScores;


    //The board of the game.
    Board b = new Board();

   // constructor
    public AIplayer() {
    }

    /*
     This method runs the minimax algorithm on the current board and returns the best move.
     returns the point at which the most optimal move can be made.
     */

    public Point returnBestMove() {
        int MAX = Integer.MIN_VALUE;
        int best = -1;

        for (int i = 0; i < rootsChildrenScores.size(); ++i) {
            if (MAX < rootsChildrenScores.get(i).score) {
                MAX = rootsChildrenScores.get(i).score;
                best = i;
            }
        }
        return rootsChildrenScores.get(best).point;
    }

    /*
     This method returns the minimum value from a given list of integers
     The parameter list is the list from which the lowest value is to be returned.
     */
    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }


    /*
     This method returns the maximum value from a given list of integers. opposite to the method above
     the parameter list is the list of integers from which the maximum value is to be returned.
     this returns the maximum value stored in the given list.
     */
    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    /*
     This method starts the minimax algorithm
     The parameter depth is the starting depth.
     The parameter turn is whose turn is it
     The parameter b is the board on which minimax is to be run.
     */
    public void callMinimax(int depth, int turn, Board b){
        rootsChildrenScores = new ArrayList<>();
        minimax(depth, turn, b);
    }

    /*
      This method evaluates a given board configuration and returns a score which encapsulates the likelihood about the player winning.
     The parameter b is the board configuration to evaluate.
      and the method an array of integers containing the evaluated scores of both the players.
     */
    public int[] evaluateBoard(Board b) {
        int retX = 0; // The 'X' player's score.
        int retO = 0; // The 'O' player's score.

        // Here each of the winning conditions are checked and the closeness of a player to winning is determined.
        // This is done so by checking the number of same elements in a continuous straight line.
        for(int p = 0; p<b.board.length; p++) {
            int[][] directions = {
                    {1,0},{-1,0},{0,1},{0,-1},
                    {1,1},{-1,1},{-1,-1},{1,-1}
            };
            for(int m = 0; m<b.board.length; m++) {
                for(int[] dir : directions) {
                    int x = m;
                    int y = p;

                    int Xscore = 0;
                    int Oscore = 0;
                    boolean increaseX = true;
                    boolean increaseO = true;
                    while(x > 0 && x < b.board.length-1 && y > 0 && y < b.board.length-1) {
                        x += dir[0];
                        y += dir[1];

                        if(b.board[y][x] == 1) increaseO = false;
                        if(b.board[y][x] == 2) increaseX = false;

                        if(b.board[y][x] == 1 && increaseX) {
                            Xscore ++;
                        }
                        if(b.board[y][x] == 2 && increaseO) {
                            Oscore ++;
                        }
                    }

                    if(retX < Xscore) retX = Xscore;
                    if(retO < Oscore) retO = Oscore;
                }
            }

            for(int n = 0; n<b.board.length; n++) {
                for(int[] dir : directions) {
                    int x = p;
                    int y = n;

                    int Xscore = 0;
                    int Oscore = 0;
                    boolean increaseX = true;
                    boolean increaseO = true;
                    while(x > 0 && x < b.board.length-1 && y > 0 && y < b.board.length-1) {
                        x += dir[0];
                        y += dir[1];

                        if(b.board[y][x] == 1) increaseO = false;
                        if(b.board[y][x] == 2) increaseX = false;

                        if(b.board[y][x] == 1 && increaseX) {
                            Xscore ++;
                        }
                        if(b.board[y][x] == 2 && increaseO) {
                            Oscore ++;
                        }
                    }

                    if(retX < Xscore) retX = Xscore;
                    if(retO < Oscore) retO = Oscore;
                }
            }
        }

        return new int[]{retX, retO};
    }

    /*
     This method handles the main minimax implementation.
     The parameter depth the depth of the search.
     The parameter the player being evaluated.
     The parameter the score of the given board configuration.
     */
    public int minimax(int depth, int turn, Board b) {

        // If any player has won, an exorbitantly high or low value is returned accordingly.
        if (b.hasXWon()) return Integer.MAX_VALUE-1;
        if (b.hasOWon()) return Integer.MIN_VALUE+1;

        // If the depth is greater than the maximum search depth, the board is evaluated and that value is returned.
        if(depth >= 4) {
            int[] scores = evaluateBoard(b);
            return scores[0] - scores[1];
        }

        // If there is a tie, then 0 is returned as neutral.
        List<Point> pointsAvailable = b.getAvailablePoints();
        if (pointsAvailable.isEmpty()) return 0;

        // The scores of the given points.
        List<Integer> scores = new ArrayList<>();

        // Now we go through each of the available moves and evaluate them by using minimax again.
        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);

            if (turn == 1) {
                b.placeAMove(point, 1);
                int currentScore = minimax(depth + 1, 2, b);
                scores.add(currentScore);
                if (depth == 0)
                    rootsChildrenScores.add(new PointsAndScores(currentScore, point));

            } else if (turn == 2) {
                b.placeAMove(point, 2);
                scores.add(minimax(depth + 1, 1, b));
            }
            b.placeAMove(point, 0);
        }

        // The minimum or maximum value is returned according to the player using the minimax algorithm.
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }
}
