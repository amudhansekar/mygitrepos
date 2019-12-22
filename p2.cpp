// Sasank Kanuri
// p2.cpp
// Purpose: Creates a tictactoe game that allows the two players to play as
// times as they want.
// Input: The input for this program is the current player's desired row and
// column they want to play their piece in.
// Process: The class that I use for this program is tictactoe.h. The program
// will ask the first player what row and column they want to place their piece
// in. The program will then check to make sure that the location is a valid.
// Then the program will ask the second player where they want to place their 
// piece. Once the first player has taken their turn, the program will check to
// see if that player has won or not. This done by calling the class member 
// function checkWinner. If a player has won, the game will exit asking if the
// players want to play again. The same will happen if the game ends in an draw.
// Outputs: The program will output, the game board, the number of wins, losses
// , draws and the rules of the game.
// Examples: 
// Welcome to tictactoe!
// Here are the rules
// -------------------
// 1. Each player will take turns selecting where they would like to place their piece
// 2. The game is over when one of the player's has filled a verticle column
// of their piece, horizontal row of their piece, or  a diagnol of their piece
// Player 1 Wins: 0
// Player 2 Wins: 0
// Draws: 0
// Games Played: 0

// 0 1 2
// 0 | |
// -|-|-
// 1 | |
// -|-|-
// 2 | |
// Player 1: What row would you like to place your piece in?
// 0
// Player 1: What column would you like to place your piece in?
// 0
// 0 1 2
// 0X| |
// -|-|-
// 1 | |
// -|-|-
// 2 | |
// Player 2: What row would you like to place your piece in?
// 1
// Player 2: What column would you like to place your piece in?
// 1
// 0 1 2
// 0X| |
// -|-|-
// 1 |O|
// -|-|-
// 2 | |
// Player 1: What row would you like to place your piece in?
// 0
// Player 1: What column would you like to place your piece in?
// 1
// 0 1 2
// 0X|X|
// -|-|-
// 1 |O|
// -|-|-
// 2 | |
// Player 2: What row would you like to place your piece in?
// 1
// Player 2: What column would you like to place your piece in?
// 0
// 0 1 2
// 0X|X|
// -|-|-
// 1O|O|
// -|-|-
// 2 | |
// Player 1: What row would you like to place your piece in?
// 0
// Player 1: What column would you like to place your piece in?
// 2
// 0 1 2
// 0X|X|X
// -|-|-
// 1O|O|
// -|-|-
// 2 | |
// Congratulations player 1 wins!
// Player 1 Wins: 1
// Player 2 Wins: 0
// Draws: 0
// Games Played: 1

// Would you like to play again? Enter Y or N N
// Thanks for playing

// Player 1 Wins: 1
// Player 2 Wins: 0
// Draws: 0
// Games Played: 1
// ...
// The same message would display if player 2 had won.
// If the game ended in a draw, "The game ended in a draw" message would display.








#include "tictactoe.h"
#include <iostream>
using namespace std;
int main()
{
  int currentPlayer;
  char userChoice;
  int playerRow;
  int playerColumn;
  bool gameOver;
  bool playerWon;
  int playerOneWins = 0;
  int playerTwoWins = 0;
  int gamesPlayed = 0;
  int numDraws = 0;
  const int space = 25;
  TicTacToe game;
  
  for(int i = 0; i < space; i++){
    cout <<endl;
  }
  
  cout <<"Welcome to tictactoe!" <<endl;
  cout <<"Here are the rules" <<endl;
  cout <<"-------------------" <<endl;
  cout <<"1. Each player will take turns selecting where they would like to"
       << " place their piece" <<endl;
  cout << "2. The game is over when one of the player's has filled a verticle column\n"
       << " of their piece, horizontal row of their piece, or "
       << " a diagnol of their piece" <<endl;
  cout <<endl;
  cout <<"Would you like to play a game? Enter Y or N ";
  cin >> userChoice;
  while(userChoice != 'Y' && userChoice != 'N'){
    cout <<"Error, please enter Y or N "; 
    cin >> userChoice;
  }
  currentPlayer = 1;
  while(userChoice == 'Y'){
	cout <<"Player 1 Wins: " <<playerOneWins <<endl;
	cout <<"Player 2 Wins: " <<playerTwoWins <<endl;
	cout <<"Draws: " <<numDraws <<endl;
	cout <<"Games Played: " <<gamesPlayed <<endl;
	cout <<endl;
    game.displayBoard();
    gameOver = false;
    playerWon = false;
    while(!gameOver){
      cout <<"Player "<<currentPlayer <<": "<<"What row would you like to place your "
           <<"piece in?" <<endl;
      cin >> playerRow;
      cout <<"Player " <<currentPlayer <<": What column would you like to place your "
           <<"piece in?" <<endl;
      cin >> playerColumn;
      while(!game.gamePlay(currentPlayer, playerRow, playerColumn)){
        cout <<"The Row and Column are occupied, please try again" <<endl;
        cout <<"Please enter a row" <<endl;
        cin >> playerRow;
        cout <<"Please enter a column" <<endl;
        cin >> playerColumn;
      }
      game.displayBoard();
      game.checkWinner (playerWon, gameOver);
      
      if(playerWon){
        cout <<"Congratulations player " <<currentPlayer <<" wins!" <<endl;
        if(currentPlayer == 1){
          playerOneWins++;
          gamesPlayed++;
        }
        else{
          playerTwoWins++;
          gamesPlayed++;
        }
      }
      else if (gameOver){
        cout <<"The game ends in a draw" <<endl;
        numDraws++;
      }
      if(!gameOver){
        currentPlayer++;
      }
      if(currentPlayer > 2){
        currentPlayer = 1;
      }
      
      
    }
	cout <<"Player 1 Wins: " <<playerOneWins <<endl;
	cout <<"Player 2 Wins: " <<playerTwoWins <<endl;
	cout <<"Draws: " <<numDraws <<endl;
	cout <<"Games Played: " <<gamesPlayed <<endl;
	cout <<endl;
    
    cout <<"Would you like to play again? Enter Y or N " ;
    cin >> userChoice;
    while(userChoice != 'Y' && userChoice != 'N'){
      cout <<"Error, please enter Y or N ";
      cin >> userChoice;
    }
  }
  
  if(userChoice == 'N'){
    cout <<endl;
    cout <<"Thanks for playing" <<endl;
    cout <<endl;
    cout <<"Player 1 Wins: " <<playerOneWins <<endl;
    cout <<"Player 2 Wins: " <<playerTwoWins <<endl;
    cout <<"Draws: " <<numDraws <<endl;
    cout <<"Games Played: " <<gamesPlayed <<endl;
    cout <<endl;
  }
  
  return 0;
}
