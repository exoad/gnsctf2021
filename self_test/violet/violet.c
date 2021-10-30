#include <stdio.h>
#include <assert.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    setenv("TZ", "JST-9", 1);
    tzset();
    srand(REDACTED);

    time_t violet;
    
    long long x = 0;

    for (int i = 0; i < 5; i++) {
	   time(&violet);
	   assert(localtime(&violet)->tm_year == 121);
	   x += violet;
	   sleep(rand() % 10000000);
    }

    printf("gnsCTF{%lld}\n", x);

    return 0;
}
