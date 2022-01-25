from bs4 import BeautifulSoup
import re
import requests

# 先获得这本小说的目录
# baseurl 目录列表的那个网址
urlCat = "https://www.xxxbiquge.com/115/115676/"

# 获取小说内容的网站
url = "https://www.xxxbiquge.com"
urlContents = []
# 模拟是人为访问而不是机器
headers = {
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36"
}

# 获得每章小说的地址
# 小说目录的位置/html/body/div[1]/div[5]/div[2]/div/dl/dd[13]
urlCatResp = requests.get(urlCat, headers=headers)
# 设置编码
urlCatResp.encoding = "utf-8"
# 用bs4
urlCatPage = BeautifulSoup(urlCatResp.text, "html.parser")
urlCatPageDiv = urlCatPage.find("div", attrs={"id": "list"})
# print(urlCatPageDiv)
# dlList = urlCatPageDiv.find_all("a")
# with open("./从红月开始的目录.txt","a",encoding="utf-8") as f1:
#     for dd in dlList[12:]:
#         cat=dd.text
#         href=dd.get("href")
#         f1.writelines(dd.text+'\n')
#         f1.writelines(href+'\n')

# print("爬取目录完成")


# 获取文章链接
with open("./从红月开始的目录.txt", "r", encoding="utf-8") as f2:
    lines = f2.readlines()
    lines_len = len(lines)
    for i in range(1, lines_len, 2):
        link = lines[i].strip()
        urlContents.append(url + link)


# 爬取文章内容
with open("./从红月开始.txt", "a", encoding="utf-8") as f3:
    for urlContent in urlContents:
        urlContetn2 = urlContent[:-5] + "_2.html"
        respContent = requests.get(urlContent, headers=headers)
        respContent.encoding = "utf-8"
        respContentPage = BeautifulSoup(respContent.text, "html.parser")
        respContentPageDiv = respContentPage.find("div", attrs={"id": "content"})
        respa = respContentPage.find("div", attrs={"class": "box_con"})
        respContentBookname = respa.find("div", attrs={"class": "bookname"}).find("h1")
        f3.write(respContentBookname.text + "\n")
        f3.write(respContentPageDiv.text)
        # print(respContentPageDiv)
        # dlList = respContentPageDiv.find_all("br")

print("爬取完成")
