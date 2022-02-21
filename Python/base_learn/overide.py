"""
# Author:         Leiyi548                        
# Date:           2022/02/16 21:23                       
"""


class Parent:
    def myMethod(self):
        print("调用父类方法")


class Child(Parent):
    def myMethod(self):
        print("调用子类方法")


if __name__ == "__main__":
    c = Child()
    c.myMethod()
    super(Child, c).myMethod()
