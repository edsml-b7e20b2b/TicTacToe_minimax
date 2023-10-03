# Tic Tac Toe Game with AI Player
This Java project implements a console-based Tic Tac Toe game where you can play against an AI player. The AI player uses the minimax algorithm to make intelligent moves.

## Table of Contents
- [Overview](#overview)
- [Classes](#classes)
  - [AIplayer](#aiplayer)
  - [Point](#point)
  - [PointsAndScores](#pointsandscores)
  - [Board](#board)
  - [TicTacToe](#tictactoe)
- [How to Play](#how-to-play)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Overview
This project is a console-based implementation of the classic Tic Tac Toe game. It features a player-versus-computer mode, where the computer employs a minimax algorithm to make strategic moves. The game's logic is divided into several classes, each responsible for different aspects of the game.

## Classes

### AIplayer
The `AIplayer` class is the heart of the AI logic. It contains the implementation of the minimax algorithm, which is used to determine the best move for the computer player. The class evaluates the game board recursively to find the optimal move.

### Point
The `Point` class represents a position on the Tic Tac Toe grid. It has attributes for the x and y coordinates, making it easy to specify a move.

### PointsAndScores
This class is a simple container that pairs a point on the board with a score. It is used by the `AIplayer` class to keep track of evaluated moves and their respective scores.

### Board
The `Board` class manages the game board itself. It tracks the state of each cell, checks for a winner, and maintains a list of available moves. The class also handles user input and displays the current state of the board.

### TicTacToe
The `TicTacToe` class acts as the orchestrator of the game. It creates instances of the `AIplayer` and `Board` classes, allowing players to interact with the game. This class prompts the user for input, processes moves, and determines the winner.

## How to Play
1. Run the `TicTacToe` class.
2. When prompted, choose who makes the first move (1 for Computer, 2 for User).
3. For each turn, input the row and column (1 to 5) where you want to place your move.
4. The game continues until there's a winner or it's a draw.

## Getting Started
To run this project, make sure you have Java installed on your system.
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the `TicTacToe` class.

## Contributing
If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes. Feel free to open issues for bug reports or feature requests.

## License
