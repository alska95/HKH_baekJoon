target = int(input())

a = []

i = 2
while 1:
    if i == target+1:
        break
    if target % i == 0:
        target //= i
        a.append(i)
        i = 2
    else:
        i+=1
if a:
    for _a in a:
        print(_a)