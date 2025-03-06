testCase = int(input())

for _ in range(testCase):
    x , y = map(int , (input().split()))
    length = y -x

    index = 0
    i =1
    iter = 0
    while index < length:
        for j in range(2):
            index +=i
            if index >= length:
                print(i+j+iter)
                break
        if index >= length:
            break
        i+=1
        iter +=1
# 2 4 6 8
# 1 2 3 3 4 4 5 5 5 6 6 6 7 7 7 7 8 8 8 8
# 1 1
# 2 11

# 3 111
# 4 121

# 5 1211
# 6 1221

# 7 12211
# 8 12221
# 9 12321

# 10 122221
# 11 123221
# 12 123321

# 13 1232221
# 14 1233221
# #