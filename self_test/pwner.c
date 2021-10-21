// user modifications

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

    fflush(stdout);
    fgets(buf, 80, f);
    puts(buf);
}

int main(void)
{
    char password[33];
    while (1)
    {
        fgets(password, 33, stdin);
        if (strcmp(password, "\x45\x49\x04\x84\x05\x84\x23\x02\x99\x32\x03\n") == 0)
        {
            puts("Woah you're a real pwner! Here's your flag:");
            flag();
        }
        else
            puts("Nope!");
    }

    exit(0);
    return 0;
}
