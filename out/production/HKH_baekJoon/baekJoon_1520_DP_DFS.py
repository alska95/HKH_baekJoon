import sys
sys.setrecursionlimit(10**9)

input = sys.stdin.readline

Height , Width = map(int, input().split())

board = [list(map(int,input().split())) for _ in range(Height)]

dx = [0 ,0 ,-1 ,1]
dy = [1 ,-1 , 0 ,0]

dp = [[-1 for _ in range(Width)] for _ in range(Height)]

def dfs(y ,x):
    if y == Height-1 and x == Width -1:
        return 1
    elif dp[y][x] != -1:
        return dp[y][x]
    else:
        dp[y][x] = 0
        currentCost = board[y][x]
        for i in range(4):
            newX = x + dx[i]
            newY = y + dy[i]
            if(0<=newX < Width and 0<=newY < Height):
                nextCost = board[newY][newX]
                if nextCost < currentCost:
                    dp[y][x] += dfs(newY, newX)
        return dp[y][x]

print(dfs(0,0))
