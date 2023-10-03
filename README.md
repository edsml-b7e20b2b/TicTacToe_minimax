# Tic Tac Toe Game with AI Player

This Java project implements a console-based Tic Tac Toe game where you can play against an AI player. The AI player uses the minimax algorithm to make intelligent moves.

## Table of Contents
- [Introduction](#introduction)
- [Overview](#overview)
- [Classes](#classes)
  - [AIplayer](#aiplayer)
  - [Point](#point)
  - [PointsAndScores](#pointsandscores)
  - [Board](#board)
  - [TicTacToe](#tictactoe)
- [How to Play](#how-to-play)
- [Getting Started](#getting-started)
- [Advanced Usage](#advanced-usage)
- [Contributing](#contributing)
- [Issues and Feedback](#issues-and-feedback)
- [License](#license)

## Introduction

This project aims to provide a comprehensive implementation of the classic Tic Tac Toe game with an advanced AI player that utilizes the minimax algorithm. The game is built in Java and structured using a set of classes to handle various aspects of gameplay, including user input, game state management, and AI strategy.

## Overview

This project is a console-based implementation of the classic Tic Tac Toe game. It features a player-versus-computer mode, where the computer employs a minimax algorithm to make strategic moves. The game's logic is divided into several classes, each responsible for different aspects of the game.

## Classes

### AIplayer

The `AIplayer` class encapsulates the logic for the AI opponent. It leverages the minimax algorithm to determine the best possible move based on the current state of the game. The minimax algorithm is a recursive function that evaluates the game board to find the optimal move that maximizes the AI's chances of winning.

### Point

The `Point` class represents a position on the Tic Tac Toe grid. It contains attributes for the x and y coordinates, allowing for easy specification of a move. This class is used to denote the location where a player intends to place their mark (X or O).


### PointsAndScores

The `PointsAndScores` class serves as a simple container that pairs a point on the board with a corresponding score. It is employed by the `AIplayer` class to maintain a record of evaluated moves and their respective scores. This aids in the decision-making process of selecting the best move.

### Board

The `Board` class manages the game board itself. It tracks the state of each cell, checks for a winner, and maintains a list of available moves. The class also handles user input and displays the current state of the board through the console. Additionally, it enforces the rules of the game, preventing invalid moves.

### TicTacToe

The `TicTacToe` class serves as the orchestrator of the game. It creates instances of the `AIplayer` and `Board` classes, enabling players to interact with the game. This class prompts the user for input, processes moves, and determines the winner based on the game's state.

## How to Play

1. Run the `TicTacToe` class.
2. When prompted, choose who makes the first move (1 for Computer, 2 for User).
3. For each turn, input the row and column (1 to 5) where you want to place your move.
4. The game continues until there's a winner or it's a draw.

## Getting Started

To run this project, ensure you have Java installed on your system. Follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the `TicTacToe` class.

## Advanced Usage

For advanced users and developers interested in extending or modifying this project, consider exploring the following opportunities:

- Implement additional AI strategies or heuristic evaluations for improved gameplay.
- Extend the game to support a graphical user interface (GUI) for a more interactive experience.
- Integrate unit tests and automated testing frameworks to ensure code reliability.

## Contributing

If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes. Feel free to open issues for bug reports, feature requests, or general feedback.

## Issues and Feedback

For any issues, bugs, or feedback, please [create an issue](https://github.com/edsml-b7e20b2b/TicTacToe_minimax/issues) in the repository. Your input is highly valued and will contribute to the ongoing development and improvement of this project.

## License

