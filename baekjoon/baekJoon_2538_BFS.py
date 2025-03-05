import sys

boardY , boardX , K = list(map(int , sys.stdin.readline().split()))

board = [[0 for _ in range(boardX)] for _ in range(boardY)]

for i in range(K):
    leftX,bottomY ,rightX ,topY =map(int,sys.stdin.readline().split())

    for j in range(leftX, rightX):
        for k in range(bottomY, topY):
            board[k][j] = 1

def display():
    for i in board:
        print()
        for j in i:
            print(j, end=' ')
    print()


Dx = [0, 0, 1, -1]
Dy = [1, -1, 0, 0]

MAX = 0


# def _solveDFS(y, x , size):
#     # tmpBoard = copy.deepcopy(board)
#     board[y][x] = 1
#     global MAX
#     MAX = max(size, MAX)
#     for i in range(4):
#         newX = x + Dx[i]
#         newY = y + Dy[i]
#         if (newX < 0 or newX >= boardX or newY < 0 or newY >= boardY):
#             continue
#         if (board[newY][newX] == 0):
#             board[newY][newX] = 1
#             size+=1
#             _solveDFS(newY, newX , size)

bfsQueue = []
size = 1
def _solveBFS(y ,x):
    global size
    board[y][x] = 1
    bfsQueue.append((y, x))
    while bfsQueue:
        y,x = bfsQueue.pop(0)
        #
        # display()
        for i in range(4):
            newX = x + Dx[i]
            newY = y + Dy[i]
            if newX < 0 or newX >= boardX or newY < 0 or newY >= boardY:
                continue
            if board[newY][newX] == 0:
                size += 1
                board[newY][newX] = 1
                bfsQueue.append((newY,newX))


def solve(y, x):
    global size
    _count = 0
    _size = []
    for i in range(boardY):
        for j in range(boardX):
            if board[i][j] == 0:
                _solveBFS(i,j)
                _size.append(size)
                size = 1
    _size.sort()
    return _size

result = solve(0,0)
print(len(result))
for i in result:
    print(i ,end=' ')