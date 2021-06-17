
# timeout
boardSize = int(input())

board = [list(map(int, input().split())) for _ in range(boardSize)]

pathDP = [[0 for _ in range(boardSize)] for _ in range(boardSize)]

# dfs전부 수행한다
# 만약 경로값이 dp에 저장되어있다면 수행하지 않고 dp값을 더한다.
dfsStack = []
Dx = [0, 0, 1, -1]
Dy = [1, -1, 0, 0]

MAX = 1
def _dfs(y, x):
    global MAX
    dfsStack.append((y, x, 1))
    a = [1]
    while dfsStack:
        y, x, days = dfsStack.pop()
        currentCost = board[y][x]

        for i in range(4):
            newY = y + Dy[i]
            newX = x + Dx[i]
            if (0 <= newX < boardSize and 0 <= newY < boardSize):
                nextCost = board[newY][newX]
                if nextCost > currentCost:
                    if(pathDP[newY][newX] != 0):
                        MAX = max(MAX , days+pathDP[newY][newX])
                    else:
                        dfsStack.append((newY, newX, days+1))
                        MAX = max(MAX , days+1)


def solve():
    global MAX
    for i in range(boardSize):
        for j in range(boardSize):
            if pathDP[i][j] == 0:
                _dfs(i,j)
                pathDP[i][j] = MAX
                MAX = 1


solve()
# print(pathDP)
print(max(map(max,pathDP)))
