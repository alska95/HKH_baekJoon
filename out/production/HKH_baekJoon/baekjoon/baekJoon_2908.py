a , b = input().split()
a = list(a)
b = list(b)
targetA = []
while a :
    targetA.append(a.pop())
targetA = "".join(map(str , targetA))

targetB = []
while b :
    targetB.append(b.pop())
targetB = "".join(map(str , targetB))


print(max(targetA, targetB))
