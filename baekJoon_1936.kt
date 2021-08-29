import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))

    var n : Int= readLine()!!.toInt()

    for(z in 0 until n){
        var st = StringTokenizer(br.readLine() , " ")
        var first = st.nextToken().toInt()
        var second = st.nextToken().toInt()
        println("${first/gcd(first,second)*second}")
    }
}

fun gcd(a : Int, b:Int): Int {
    var first = a
    var second = b
    var tmp : Int
    while(second!= 0){
        tmp = first % second
        first = second
        second = tmp
    }

    return first
}