import threading
import time
from queue import Queue

def sing(num,end):
    for i in range(num,end+1):
        print("sing"+str(i))
        time.sleep(0.5)

def dance(num,end):
    for i in range(num,end+1):
        print("dancing"+str(i))
        time.sleep(0.5)

def main():
    #创建启动线程
    t_sing = threading.Thread(target=sing,args=(5,9)) #这里的args相当于传递给函数参数
    t_dance = threading.Thread(target=dance,args=(6,9)) 

    t_sing.start();
    t_dance.start();

if __name__ == "__main__":
    main()


#这是一个多行注释
"""
test0
main1
test1
main2
"""
