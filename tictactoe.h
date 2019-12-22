// Sasank Kanuri
// tictactoe.h
// 04/27/2017
// Purpose: This purpose of this class is to create the attributes and member
// functions to create a tictactoe game.

#ifndef TICTACTOE_H
#define TICTACTOE_H
#include <iostream>
#include <cassert>
using namespace std;


class TicTacToe
{
 public:
  TicTacToe(); 
  bool checkWinner(bool &won, bool &done);
  // Pre: None.
  // Post: The function will stop the gameplay if bools return true.
  bool gamePlay(int currentPlayer, int row, int column);
  // Pre: The current player must have selected what row and column they want 
  // their piece in.
  // Post: None
  ~TicTacToe();
  void displayBoard();
  // Pre: The two dim array must have been created succesfully for this function
  // to work.
  // Post: None
  TicTacToe(const TicTacToe &oldGame);
  void operator= (const TicTacToe &right);
  
  
  
  
 private:
  char **board;
  void resetGame();
  // Pre:None
  // Post: None
  int size;
  bool checkWinWithGivenChar(char givenChar);
  // Pre: A piece must have been placed on the game board.
  // Post: This function will determine if a player's piece has occupied 
  // consecutive rows, columns, or diaganols.
  
};

#endif // TICTACTOE_H

