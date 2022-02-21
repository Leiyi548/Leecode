"""
# Author:         Leiyi548                        
# Date:           2022/02/16 21:00                       
"""


class people:
    name = ""
    age = 0
    weight = 0

    def __init__(self, n, a, w):
        self.name = n
        self.age = a
        self.weight = w

    def speak(self):
        print("%s 说: 我 %d岁." % (self.name, self.age))


# extend people
class student(people):
    grade = ""

    def __init__(self, n, a, w, g):
        # use father_class __init__
        people.__init__(self, n, a, w)
        self.grade = g

    def speak(self):
        print("%s 说: 我 %d岁, 我在读 %d 年级" % (self.name, self.age, self.grade))


class speaker:
    topic = ""
    name = ""

    def __init__(self, n, t):
        self.namer = n
        self.topic = t

    def speak(self):
        print("我叫 %s,我是一名演讲家,我演讲的主题是 %s" % (self.name, self.topic))


# multiple extend example
class sample(speaker, student):
    a = ""

    def __init__(self, n, a, w, g, t):
        student.__init__(self, n, a, w, g)
        speaker.__init__(self, n, t)


if __name__ == "__main__":
    s = student("ken", 10, 60, 3)
    s.speak()
    test = sample("Tim", 25, 80, 4, "Python")
    test.speak()
