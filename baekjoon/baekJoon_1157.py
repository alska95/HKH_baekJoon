targetString = list(input())

counter = [0 for _ in range(40)]

while targetString:
    counter[(ord(targetString.pop())-64)%32] +=1

MAX = max(counter)
flag = -1
for i in range(40):
    if(counter[i] == MAX  ):
        if flag == -1:
            flag = 0
        else :
            if flag == 0:
                flag = 1

if flag == 1 :
    print('?')
else:
    print(chr(counter.index(max(counter))+64))
