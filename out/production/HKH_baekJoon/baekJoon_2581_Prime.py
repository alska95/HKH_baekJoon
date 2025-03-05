M = int(input())
N = int(input())

prime = [2, 3]

for i in range(3, N + 1):
    primeFlag = 1
    for p in prime:
        if i % p == 0:
            primeFlag = 0
            break
    if primeFlag == 1:
        prime.append(i)

target = []
for p in prime:
    if N >= p >= M:
        target.append(p)

if target:
    print(sum(target))
    print(target[0])

else:
    print(-1)
