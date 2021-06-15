

dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]


def BFS(y, x):
    global MAX
    bfsQueue = {(y, x, targetArray[y][x])}

    while bfsQueue:
        y, x, charList = bfsQueue.pop()

        for i in range(4):
            newY = y + dy[i]
            newX = x + dx[i]

            if ((0 <= newY < row) and (0 <= newX < column)) and (targetArray[newY][newX] not in charList):
                bfsQueue.add((newY ,newX ,charList + targetArray[newY][newX]))
                MAX = max(MAX, len(charList ) +1)


row, column = map(int, input().split())
targetArray = [list(input()) for _ in range(row)]

MAX = 1
BFS(0, 0)
print(MAX)
