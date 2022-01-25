"""
author: Leiyi548
Lences: MIT
date: 2022年-01月-05日
"""


# define favorite editor
def favouriteEditofr():
    favouriteEditofr = str(input("what is you favorite editors?\n"))
    if favouriteEditofr == "vscode":
        print("Microsoft is a evil editor")
        print("I love vscode meetoo")
    elif favouriteEditofr == "vim":
        print("Vim is good")
    elif favouriteEditofr == "neovim":
        print("I use neovim,now")
        print("neovim is better than vscode")
        print("but edit html have to use vscode")
    else:
        print("use your favorite editors" + favouriteEditofr)
        print("hello,world")
        print("favouriteEditofr")
        print("neovim awesome!!!")


def rangerBack():
    print("====================")
    print("ranger back i need you!!!")
    print("my ranger is back I'm very happy")
    print("yes,I need you...")
    print("I think neovim is better than vscode")


def favouriteColorscheme(colorschemeName):
    """python

    Args:
        colorschemeName:this is my favourite colorscheme name
    """
    print("My favourite Colorscheme is rose-pine")
    print("yes,I think this is very good!!!")
    print("hello,world,yes,easymotion")
    print(colorschemeName)
    print("easymotion")
    print("yes,I love you")
    print("easymotion")
    print("easymotion")


if __name__ == "__main__":
    favouriteColorscheme("rose-pine")
    favouriteEditofr()
