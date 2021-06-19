case = int(input())
count = 0
for _ in range(case):
    target = input()
    i = 0
    a = []
    flag = 0
    while i < len(target):
        if(target[i] in a):
            flag = 1
            break
        tmp = target[i]
        a.append(tmp)
        i+=1
        if i < len(target):
            while target[i] == tmp:
                i+=1
                if i >= len(target):
                    break
    if flag == 0:
        count+= 1
print(count)