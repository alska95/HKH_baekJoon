
a , b = list(input().split())
tmp = [0 for _ in range(10001)]

a= list(a)
b= list(b)

def addFunc(a, b):
    result = int(a) + int(b)
    return (result // 10 , result %10)

i = 0
while a or b :
    tmp1 = 0
    tmp2 = 0
    if a:
        tmp1 = a.pop()
    if b:
        tmp2 = b.pop()
    second , first = addFunc(tmp1, tmp2)
    tmp[i] += first
    if tmp[i] >= 10:
        tmp[i] %= 10
        tmp[i+1] +=1
    tmp[i+1] += second
    i+=1


while 1:
    result = tmp.pop()
    if result != 0:
        tmp.append(result)
        break

resultS = ''
for i in range(1,len(tmp)+1):
    resultS += str(tmp[len(tmp)-i])

print(resultS)
