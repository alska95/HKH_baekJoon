import sys
TestCase = int(input())


for _ in range(TestCase):
    iter , targetString= input().split()
    iter = int(iter)
    targetString = list(targetString)
    while targetString:
        target = targetString.pop(0)
        for _ in range(iter):
            print(target , end = '')
    print()