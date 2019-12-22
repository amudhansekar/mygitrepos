// Sasank Kanuri
// tictactoe.cpp
// Implementation of tictactoe as described in tictactoe.h

#include "tictactoe.h"


TicTacToe::TicTacToe() // constructor
{
  size = 3;
  board = new char*[size];
  assert(board != nullptr);
  for (int i = 0; i < size; i++){
    board[i] = new char[size];
    assert(board[i] != nullptr);
  }
  resetGame();
}

// Purpose: The purpose of this function is to create the game board for the 
// game.
void TicTacToe::displayBoard()
{
  cout <<" ";
  for(int i = 0; i < size; i++){
    cout <<i <<" ";
  }
  cout <<endl;
  for(int i = 0; i < size; i++){
    cout<< i;
    for(int j = 0; j < size; j++){
      
      if(j < (size - 1)){
        cout <<board[i][j] <<"|";
      }
      else{
        cout <<board[i][j];
      }
    }
    cout <<endl;
    cout <<" ";
    if(i<(size - 1)){
      for(int j = 0; j < size; j++){
        
        if(j < (size - 1)){
          cout <<"-|";
        }
        else{
          cout<<"-";
        }
      }
      cout <<endl;
      
    }
  }
  
}

// Purpose: The purpose of this function is to place the current player's 
// piece in their desired position.
bool TicTacToe::gamePlay(int currentPlayer, int row, int column)
{
  if(board[row][column] != ' '){
    return false;
  }
  if(currentPlayer == 1){
    board[row][column] = 'X';
  }
  else{
    board[row][column] = 'O';
  }
  return true;
}

// Purpose: The purpose of this function is to reset the game board to blanks
// once the game is over.
void TicTacToe::resetGame()
{
  for(int i = 0; i < size; i++){
    for(int j = 0; j < size; j++){
      board[i][j] = ' ';
    }
  }
}

// Purpose: The purpose of this function is to check to see if any player has 
// won or not.
bool TicTacToe::checkWinner(bool &won, bool &done)
{
  won = checkWinWithGivenChar('X');
  if(!won){
    won = checkWinWithGivenChar('O');
    if(!won){
      done = true;
      for(int i = 0; i < size && done; i++){
        for(int j = 0; j < size && done; j++){
          if((board[i][j] == ' ')){
            done = false;
          }
        }
      }
    }
    
  }
  if(won){
    done = true;
    resetGame();
  }
  return won;
}

// Purpose: The purpose of this function is to check if an X or O is found in
// a consecutive row, column or diaganol. 
bool TicTacToe::checkWinWithGivenChar(char givenChar)
{
  bool lineFilledWithSameChar;
  bool lineFound = false;
  for(int i = 0; i < size && !lineFound; i++){
    lineFilledWithSameChar = true;
    for(int j = 0; j < size; j++){
      if(board[i][j] != givenChar){
        lineFilledWithSameChar = false;
      }
      
    }
    if(lineFilledWithSameChar){
      lineFound = true;
    }
  }
  if(!lineFound){
    for(int j = 0; j < size && !lineFound; j++){
      lineFilledWithSameChar = true;
      for(int i = 0; i < size; i++){
        if(board[i][j] != givenChar){
          lineFilledWithSameChar = false;
        }
      }
      if(lineFilledWithSameChar){
        lineFound = true;
      }
    }
    
  }
  
  if(!lineFound){
    lineFilledWithSameChar = true;
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(i + j == (size - 1)){
          if(board[i][j] != givenChar){
            lineFilledWithSameChar = false;
          }
        }
      }
    }
    
    if(lineFilledWithSameChar){
      lineFound = true;
    }
  }
  
  if(!lineFound){
    lineFilledWithSameChar = true;
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(i == j){
          if(board[i][j] != givenChar){
            lineFilledWithSameChar = false;
          }
        }
      }
    }
    
    if(lineFilledWithSameChar){
      lineFound = true;
    }
  }
  return lineFound;
}

TicTacToe::~TicTacToe()
{
  for (int i = 0; i < size; i++){   
    delete [] board[i];
  }
  
  delete [] board;
}

TicTacToe::TicTacToe(const TicTacToe &oldGame)
{
  size = oldGame.size;
  board = new char*[size];
  assert(board != nullptr); 
  for (int i = 0; i < size; i++){
    board[i] = new char[size];
    assert(board[i] != nullptr);
  }
}


void TicTacToe::operator= (const TicTacToe &right)
{
  for (int i = 0; i < size; i++){
    delete [] board[i];
  }
  delete [] board;
  
  size = right.size;
  board = new char*[size];
  assert(board != nullptr); 
  for (int i = 0; i < size; i++){
    board[i] = new char[size];
    assert(board[i] != nullptr);
  }
  resetGame();
}
