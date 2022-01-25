import requests
from lxml import etree
import threading
import time


def getAllCat(url, urlCat):
    print("开始获取文章链接")
    # 2.获取所有页面的链接 先获取放有所有链接的页面
    urlCatList = ["http://www.biqu.fun/xs/6674/{}".format(i) for i in range(2, 27)]
    urlCatList.insert(0, urlCat)

    for urlCatEvery in urlCatList:
        urlCatEveryResp = requests.get(urlCatEvery)
        selectorCat = etree.HTML(urlCatEveryResp.text)
        urlList = selectorCat.xpath("/html/body/div[3]/div[2]/div/div[2]/ul/li/a/@href")
        urlListContent = selectorCat.xpath(
            "/html/body/div[3]/div[2]/div/div[2]/ul/li/a/text()"
        )

        with open("./从红月开始每个章节的链接.txt", "a", encoding="utf-8") as f1:
            for i in range(len(urlList)):
                f1.writelines(urlListContent[i] + "\n")
                f1.writelines(url + urlList[i] + "\n")
    print("OK!!!!")


def verificationConnect(url, header):
    try:
        resp = requests.get(url, headers=header)
        code = resp.status_code
        if code >= 200 and code < 300:
            return True
        else:
            print("被这个网站给反爬了.....")
            return False
    except Exception as e:
        print(url + "访问出错")
        return False


def getContent(url, header, fileName, title, i):
    if verificationConnect(url, header):
        time.sleep(2)
        resp = requests.get(url, headers=header)
        selector = etree.HTML(resp.text)
        contentList = selector.xpath('//*[@id="content"]/p/text()')
        with open(fileName, "a", encoding="utf-8") as f:
            if i == 1:
                f.write(title + "\n")
            for content in contentList:
                f.write(content + "\n")


if __name__ == "__main__":
    startTime = time.time()
    # 笔趣阁的url
    # url= "http://www.biqu.fun"

    # 存放小说内容的文件和路径
    fileName = "./从红月开始.txt"

    # 用来清空文本内容
    with open(fileName, "w", encoding="utf-8") as f1:
        f1.write("")
    # userAgent 用来伪装自己是浏览器访问
    header = {
        "user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36"
    }

    # 1.先获取一个页面的链接
    # urlCat="http://www.biqu.fun/xs/6674/"

    # 2.获取所有链接
    # getAllCat(url,urlCat)

    # 3.再从所有链接中获取链接内的文本
    print("开始爬取文章内容")
    with open("./从红月开始每个章节的链接.txt", "r", encoding="utf-8") as f:
        lines = f.readlines()
        for i in range(1, len(lines), 2):
            urlContent = lines[i].strip()
            urlContent2 = urlContent[:-5] + "_2.html"
            title = lines[i - 1].strip()
            print("开始爬取" + title)
            # 尝试下多线程
            t1 = threading.Thread(
                target=getContent,
                name="Thread1",
                args=(
                    urlContent,
                    header,
                    fileName,
                    title,
                    1,
                ),
            )
            t2 = threading.Thread(
                target=getContent,
                name="Thread2",
                args=(
                    urlContent2,
                    header,
                    fileName,
                    title,
                    2,
                ),
            )

            # 启动守护线程
            t1.setDaemon(True)
            t2.setDaemon(True)

            # 启动多线程
            t1.start()
            t2.start()

            #
            # print(threading.current_thread().name+"正在运行")
            # print(threading.current_thread().name+"正在运行")

            # getContent(urlContent,header,fileName,title,1)
            # getContent(urlContent2,header,fileName,title,2)
            print("爬取完毕本章节")

    print("这本小说被我爬取完毕")
    endTime = time.time()
    print(endTime - startTime)
