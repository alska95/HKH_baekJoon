package baekjoon

import java.util.*

fun main(){
    var n : Int= readLine()!!.toInt()
    var q : Queue<Int> = LinkedList()
    for(i in 1..n){
        q.add(i)
    }
    while(!q.isEmpty()){
        print("${q.poll()} ")
        if(q.isEmpty())
            break
        else
            q.add(q.poll())
    }
}
