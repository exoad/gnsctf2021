#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

const int DIARY_SZ = 1600;
const int PAGE_SZ = 160;

// you may ask why these are up here
// answer: gcc is absolutely horrible and this is the only way to get it to arrange stack vars the way i want

char* page;
int op;
int page_num;

int main(void) {
    // this challenge is easy, making it was not :(

    setvbuf(stdout, NULL, _IONBF, 0);

    // horrible coding lmao
    FILE* f = fopen("./bytecode", "rb");
    char diary[DIARY_SZ];

    void (*flip_page)(char**, int*) = (void (*)(char**, int*))(diary + 2 * PAGE_SZ);
    void (*write_page)(char*) = (void (*)(char*))(diary + PAGE_SZ);
    void (*read_page)(char*) = (void (*)(char*))(diary);

    page = diary;
    page_num = 0;

    fread(diary, DIARY_SZ, 1, f);

    while (true) {
        printf("\n[Page #%d]\n", page_num);
        printf("Choose a menu option:\n0 - read page\n1 - write page\n2 - flip page\n3 - exit\n");

        scanf("%d", &op);

        if (op == 0)
            read_page(page);
        else if (op == 1)
            write_page(page);
        else if (op == 2)
            flip_page(&page, &page_num);
        else
            break;
    }

    exit(0);
    return 0;
}