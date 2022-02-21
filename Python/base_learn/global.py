"""
# Author:         Leiyi548                        
# Date:           2022/02/16 21:45                       
"""

num = 1


def fun1():
    global num
    print("global nubmer:", num)
    num = 123
    print(num)


def outer():
    num = 10

    def inner():
        nonlocal num
        num = 100
        print(num)

    print(num)
    inner()
    print(num)


if __name__ == "__main__":
    outer()
