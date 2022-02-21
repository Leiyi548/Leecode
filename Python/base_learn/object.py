"""
# Author:         Leiyi548                        
# Date:           2022/02/16 20:55                       
"""


class Myclass:
    """This is a smaple class example"""

    i = 12345

    def f(self):
        return "hello,world"


class Test:
    def prt(self):
        print(self)
        print(self.__class__)


if __name__ == "__main__":
    x = Myclass()
    print("Myclass 类的属性 i 为:", x.i)
    print("Myclass 类的方法 f 输出为:", x.f())

    t = Test()
    t.prt()
