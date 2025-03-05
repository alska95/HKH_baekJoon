package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var a=Array<Array<Int>>(3){Array<Int>(2){ _ ->0}}
    for(i in 0..2){
        val st = StringTokenizer(br.readLine())
        for(j in 0..1){
            a[i][j] = st.nextToken().toInt()
        }
    }
    var result = Array<Int>(2) { 0 }
    if(a[0][1] == a[1][1]){
        result[1] = a[2][1]
    }else if(a[2][1] == a[1][1]){
        result[1] = a[0][1]
    }else{
        result[1] = a[1][1]
    }
    if(a[0][0] == a[1][0]){
        result[0] = a[2][0]
    }else if(a[2][0] == a[1][0]){
        result[0] = a[0][0]
    }else{
        result[0] = a[1][0]
    }

    var y:Int = result[1]
    var x:Int = result[0]
    println("$x $y")

}
