package baekjoon

import java.time.LocalDateTime

fun main(){
    val now = LocalDateTime.now()
    if(now.monthValue < 10)
        println("${now.year}-0${now.monthValue}-${now.dayOfMonth}")
    else
        println("${now.year}-${now.monthValue}-${now.dayOfMonth}")
}
