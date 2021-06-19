target = int(input())
i = 1
while 1:
    if target - i <= 0: #총합 = i+1
        sum = i+1
        top , bottom = 0 ,0
        if i%2 == 0:
            top = target
            bottom = sum - top
        else:
            bottom = target
            top = sum - bottom
        break
    target = target - i
    i+=1

print(str(top) + "/" + str(bottom))


# 3일때 i = 2 , result = 2 top = 2 bottom = 1
# top = result top = sum - bottom

# 4일때 i = 3 , result = 1 top = 3 , bottom = 1
# sum = 4 bottom = result bottom = sum - top

# 5 i = 3 , result = 2 top 2 bottom 2
# sum = 4 top = result bottom = sum -top

# 7 i = 4 , result = 1 top 1 bottom 4
# sum = 5 top = result bottom = sum - top