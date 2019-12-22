#include <pthread.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

const char* MESSAGE_ONE = "This is thread 1";
const char* MESSAGE_TWO = "This is thread 2";


/* printMessageThreadRoutine
 *   this is the starting point for our threads
 *   each thread will print its message 1000000 times, then end
 */
void* printMessageThreadRoutine (void* threadArg) {
  const char* message = (const char*) threadArg;

  int i;
  for (i = 0; i < 1000000; i++) {
    printf("%s\n", message);
  }

  return NULL;
}


int main (int argc, char** argv) {
  pthread_t tid1, tid2;
  int error = -1;

  /* create the first thread */
  error = pthread_create(&tid1, NULL,
                         printMessageThreadRoutine, (void*) MESSAGE_ONE);
  if (error != 0) {
    printf("FATAL ERROR creating thread 1: %s\n", strerror(error));
    exit(1);
  }

  /* create the second thread */
  error = pthread_create(&tid2, NULL,
                         printMessageThreadRoutine, (void*) MESSAGE_TWO);
  if (error != 0) {
    printf("FATAL ERROR creating thread 2: %s\n", strerror(error));
    exit(1);
  }

  /* wait for thread 1 to finish */
  error = pthread_join(tid1, NULL);
  if (error != 0) {
    printf("WARNING - failed to join thread 1: %s\n", strerror(error));
  }

  /* wait for thred 2 to finish */
  error = pthread_join(tid2, NULL);
  if (error != 0) {
    printf("WARNING - failed to join thread 2: %s\n", strerror(error));
  }

  return 0;
}
