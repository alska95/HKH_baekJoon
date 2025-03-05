import sys

data = list(map(int, sys.stdin.readline().split()))

boardY = data.pop(0)
boardX = data.pop(0)
K = data.pop(0)

board = [[0 for _ in range(boardX)] for _ in range(boardY)]


for i in range(K):
    try:
        leftX = data.pop(0)
        bottomY = data.pop(0)
        rightX = data.pop(0) - 1
        topY = data.pop(0) - 1

        for j in range(leftX, rightX +1):
            for k in range(bottomY, topY +1):
                board[k][j] = 1
    except:
        print()

def display():
    for i in board:
        print()
        for j in i:
            print(j, end=' ')
    print()


Dx = [0, 0, 1, -1]
Dy = [1, -1, 0, 0]

MAX = 0
def _solve(y, x , size):
    # tmpBoard = copy.deepcopy(board)
    board[y][x] = 1
    global MAX
    MAX = max(size, MAX)
    for i in range(4):
        newX = x + Dx[i]
        newY = y + Dy[i]
        if (newX < 0 or newX >= boardX or newY < 0 or newY >= boardY):
            continue
        if (board[newY][newX] == 0):
            board[newY][newX] = 1
            size+=1
            _solve(newY, newX , size)


def solve(y, x):
    global MAX
    _count = 0
    size = []
    for i in range(boardY):
        for j in range(boardX):
            if board[i][j] == 0:
                _solve(i,j,1)
                size.append(MAX)
                MAX = 0
                _count += 1
    size.sort()
    return _count, size

result = solve(0,0)
print(result[0])
for i in range(result[0]):
    print(result[1][i] , end=' ')