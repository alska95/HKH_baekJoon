fun main(){
    var T = readLine()!!.toInt()

    for(i in 1..T) {
        var n = readLine()!!.toInt()
        var dp = Array(n+2,{0})
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        for(j in 3..n){
            dp[j] = dp[j-1]+dp[j-2]+dp[j-3]
        }
        println(dp[n])
    }

}