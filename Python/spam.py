# import random
import time
import pyautogui

txt = "I love Python"

time.sleep(5)
for i in range(4):
    pyautogui.typewrite(txt)
    pyautogui.press("enter")
    time.sleep(2)
