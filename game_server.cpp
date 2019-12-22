 // Server.cpp

// for in_port_t and in_addr_t
// using a multithreaded program
// for protocol type, pid, clock_t,
// pthread_mutex_t, trace_id_t
// TCP/IP

#include <pthread.h>       
#include <netinet/in.h> 
#include <sys/types.h>   
#include <sys/socket.h>
#include <unistd.h>
#include <errno.h>  

// file reading and string inputs
#include <fstream>
#include <iostream>
#include <string>
#include <ctime>
#include <cstring>
#include <sstream>

using namespace std;

const int TOTAL_NUMWORDS = 57489;
const int GRADY_PORT_START = 10220;
const int GRADY_PORT_END = 10229;
const int LEADER_BOARD = 3; 
const int MAX_WORD_LENGTH = 1500; 
const string PATH_NAME = "/home/fac/lillethd/cpsc3500/projects/p4/words.txt"; 

struct leaderBoard
{
  string name;
  float score;
};

// A. connecting server to client
//    --------------------------
// connect to client
// listen
// close socket (down)

// B. /Hangman Server /
//   /---------------/

// when client connects-> create a new thread to process that client
// to protect shared data using mutex
pthread_mutex_t HangmanGame_mutex;
string word[TOTAL_NUMWORDS];    // to facilitate the random access of words in the file 
struct leaderBoard LastBoard[LEADER_BOARD];


void checkGuess(string &blanks, char guess, string word)
{
  cout << " Inside the server here, the word is hdidden from the player." << endl;
  cout << " The server can see the guess(s), but the player cannot see" << endl;
  cout << " the word until she/he finds it." << endl;
  cout << " Let's see if he/she will guess it! " << endl;

  cout << "Checking that the guess is valid!! " << endl;
  cout <<" ----------------------------------" << endl;
  cout << " The guess is: " << guess << endl;
  cout << " The word the player needs to find is: " << word << endl;

  for(int i = 0; i < word.length(); i++){
    // To be removed: check to know what the word at i is really
    cout << " guess = " << guess << endl;
    cout << " word at i " << word[i] << endl;
    
    if(guess == word[i]){  // To add if player guesses more than one char 
      blanks[i] = guess;
    }
  }
}



// C. /working on LeaderBoard / 
//   /-----------------------/
// this function will save the three lowest score of the game
// It will check for any empty spaces, 



/* This function will fill in the blanks if the player's letter is a match
void fillingBlanks(string &blanks, string word, char guess)
{
  for(int i = 0; i < word.length(); i++){
    if(guess == word[i]){
      blanks[i] = guess;
    }
  }
}
*/

// In this function, we will be selecting the three top scores to
// display in the leaderBoard, thus also check if we still need more
// players name: we are going to only display three 
void leaderBoardcheck(float newestScore, string newestPlayer)
{
 
  bool onemorePlayerName = true;
  leaderBoard firstScore;
  float *highestScore = LastBoard[0].score;
  int scorePos = 0;
  
  // getting the struct while starting with an empty leaderBoard
  firstScore.score = newestScore;
  firstScore.name = newestPlayer;

  /* to check if we still enter more
  for(int i = 0; i < LEADER_BOARD; i++){
    if(LastBoard[i].name == " "){
      onemorePlayerName = true;
    }
    }
    NOT NEEDED
  */
  
  // at this point we have either found the top 3 scores or not:
  // keep looking, or start now ordering those scores 
  if(onemorePlayerName){
    for(int i = 0; i < LEADER_BOARD ; i++){
      if(LastBoard[i].name == " "){
        LastBoard[i] = firstScore;
      }
    }
  }
  else{
    // getting only lower scores
    onemorePlayerName = false;
    for(int i = 0; i < LEADER_BOARD; i++){
      if(newestScore < LastBoard[i].score){ onemorePlayerName = true;}
    }

    if(!onemorePlayerNmae){  /*do nothing*/ }
    else{
      // replace all the highest score with the lowest ones
      for (int i = 1; i < LEADER_BOARD; i++){
        if (LastBoard[i].score > highestScore){
          highestScore = LastBoard[i].score;
          scorePos = i;
        }
      }
      LastBoard[scorePos] = firstScore;
    }
  }

  cout << " Leader Board: " << endl;
  for (int i = 0; i < LEADER_BOARD; i++){
    cout << i << "." << LastBoard[i].name << LastBoard[i].score << endl;
  }
}


  // because we only have to display the lowest score,
  // if newestScore < previous score , player score = newestScore

void printLeaderBoard()
{
  
}
  

