"""
# Author:         Leiyi548                        
# Date:           2022/02/16 21:32                       
"""


from typing import Counter


class JustCounter:
    __secretCount = 0
    publicCount = 0

    def count(self):
        self.__secretCount += 1
        self.publicCount += 1
        print(self.__secretCount)


class Site:
    def __init__(self, name, url):
        self.name = name
        self.__url = url

    def who(self):
        print("name :", self.name)
        print("url :", self.__url)

    def __foo(self):
        print("This is a private way")

    def foo(self):
        print("This is a public way")
        self.__foo()


if __name__ == "__main__":
    x = Site("baidu", "www.baidu.com")
    x.who()
    x.foo()
