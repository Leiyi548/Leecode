"""
# Author:         Leiyi548                        
# Date:           2022/02/09 22:11                       
# Description:     
"""

import os

# print("检验权限模式" + os.access())
a, b = 0, 1
while b < 1000:
    print(b, end=",")
    a, b = b, a + b
print("end")
