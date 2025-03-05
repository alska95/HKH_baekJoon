package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(){
    var dx = arrayOf(0,0,1,-1)
    var dy = arrayOf(1,-1,0,0)
    var sizeY:Int
    var sizeX:Int

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine(), " ")
    sizeY =  st.nextToken().toInt()
    sizeX =  st.nextToken().toInt()

    fun makeVulnerable(board: Array<Array<Int>>, y: Int, x: Int) {
        val bfsQueue: Queue<IntArray> = LinkedList()
        board[y][x] = -1
        bfsQueue.add(intArrayOf(y, x))
        while (!bfsQueue.isEmpty()) {
            val cur = bfsQueue.poll()
            for (i in 0..3) {
                val nextX: Int = cur[1] + dx[i]
                val nextY: Int = cur[0] + dy[i]
                if (nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY)
                    continue
                if (board[nextY][nextX] == 0) {
                    board[nextY][nextX] = -1
                    bfsQueue.add(intArrayOf(nextY, nextX))
                }
            }
        }
    }


    var board = Array(sizeY){Array(sizeX){0}}
    var cheeseList = ArrayList<Array<Int>>()

    for(i in 0 until sizeY){
        st = StringTokenizer(br.readLine() , " ")
        for(j in 0 until sizeX){
            var target = st.nextToken().toInt()
            board[i][j] = target
            if(target == 1)
                cheeseList.add(arrayOf(i,j))
        }
    }

    var count = 0
    var size = 0

    makeVulnerable(board , 0 ,0)
    while(cheeseList.isNotEmpty()){
        count++
        var iter = 0
        size = cheeseList.size
        var removeList = ArrayList<Array<Int>>()
        for(i in 0 until size){
            var cur = cheeseList[iter++];
            for(j in 0 until 4){
                if(board[cur[0]+dy[j]][cur[1]+dx[j]] == -1){
                    cheeseList.removeAt(--iter);
                    removeList.add(arrayOf(cur[0],cur[1]))
                    break;
                }
            }
        }
        for (i in removeList.indices) {
            val target: Array<Int> = removeList.get(i)
            board[target[0]][target[1]] = -1
            makeVulnerable(board, target[0], target[1])
        }
    }
    print("$count\n$size")

}
