#include <stdio.h>

/* Compute n! recursively. */
unsigned long factorial(unsigned int n)
{
    if (n <= 1)
        return 1;
    return n * factorial(n - 1);
}

int main(void)
{
    for (unsigned int n = 0; n <= 10; n++)
        printf("%2u! = %lu\n", n, factorial(n));
    return 0;
}
