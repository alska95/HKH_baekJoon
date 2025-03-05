Num , K = map(int , input().split())

Coins = []
for _ in range(Num):
    Coins.append(int(input()))
INF = 20000000
CoinValue = [INF for _ in range(K+10)]

for i in Coins:
    if(i <= K+1):
        CoinValue[i] = 1


for i in range(1,K+1):
    tmp = []
    for j in Coins:
        if j <= i and CoinValue[i-j] != INF:
            CoinValue[i] =min(CoinValue[i] , CoinValue[i-j]+1)



if CoinValue[K] == INF:
    print(-1)
else:
    print(CoinValue[K])
