#引入正则表达式
import re


# pattern 为要校验的规则
# str 为要进行检验的字符串
# result = re.match(pattern,str)
# 如果result不为none,则group方法则对result进行数据提取
# result.group

#例一:验证手机号是否符合规则(不考虑边界问题)
#1.都是数字 2.长度位11 3.第一位是1 4.第二位是35678中的一位
#pattern = "1[35678]\d{9}"
#phoneStr = "18230092223"
#result = re.match(pattern,phoneStr)
#print(result.group())


# pattern = r"^\w+\s\bve\b\sr"
# str = "ho ve r"
# result = re.match(pattern,str)
#print(result.group())

content='''
苹果是红色
香蕉是黄色
叶子是绿色
天空是蓝色
'''
s1="http://www.biqu.fun/txt/6674_4500992.html"

s2=s1[:-5]+"_2.html"
print(s2)
a = re.sub('.*.html','',s1,3)
