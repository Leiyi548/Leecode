"""
# Author:         Leiyi548                        
# Date:           2022/02/09 22:17                       
"""
import sys

# F0 = 0,F1 = 1,F2 =  1,F3 = 2
# Fn = Fn-1 + Fn-2
def fibonacci(n):
    if n < 2:
        return n
    else:
        return fibonacci(n - 2) + fibonacci(n - 1)


def fibonacci_yield(n):
    a, b, counter = 0, 1, 0
    while True:
        if counter > n:
            return
        yield a
        a, b = b, a + b
        counter += 1


if __name__ == "__main__":
    print(fibonacci(2))
