testCase = int(input())
for _ in range(testCase):
    floor , room , client = map(int, input().split())
    resultF = client % floor
    resultR = client // floor+1
    if resultF == 0:
        if(resultR-1 < 10):
            print(str(floor)+"0"+str(resultR-1))
        else:
            print(str(floor) + str(resultR-1))
    else:
        if(resultR < 10):
            print(str(resultF)+"0"+str(resultR))
        else:
            print(str(resultF) + str(resultR))

