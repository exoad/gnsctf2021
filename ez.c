// modified version for easier testing
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>

void flag()
{
  char buf[80];
  FILE *f = fopen("./flag.txt", "r");
  if (f == NULL)
  {
    printf("Flag File is Missing. please contact an Admin if you are running this on the shell server.\n");
    exit(0);
  }

  fgets(buf, 80, f);
  puts(buf);
}

bool login()
{
  char pwd[8];
  puts("What's the password?");
  gets(pwd);
  return strcmp(pwd, "ezpzlemonsqueezy") == 0;
}

int main(void)
{
  login();
  while (!login())
  {
    puts("nope");
    login();
  }
  puts("yes!");

  exit(0);

  return 0;
}