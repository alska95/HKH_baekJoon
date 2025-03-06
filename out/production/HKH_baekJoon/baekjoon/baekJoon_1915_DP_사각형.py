Height , Width = map(int , input().split())

board = [list(input()) for _ in range(Height)]

dp = [[int(x) for x in y] for y in board]

result = 0
for y in range(Height):
    for x in range(Width):
        if dp[y][x] != 0:
            if y-1 >=0 and x-1 >= 0:
                dp[y][x] = min(dp[y-1][x-1] , dp[y][x-1], dp[y-1][x])+1
        result = max(dp[y][x] , result)

print(result**2)