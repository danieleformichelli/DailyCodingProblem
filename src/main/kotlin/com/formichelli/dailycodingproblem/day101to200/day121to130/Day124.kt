package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
You have 100 fair coins and you flip them all at the same time. Any that come up tails you set aside. The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains?

Write a function that, given n, returns the number of rounds you'd expect to play until one coin remains.
*/
object Day124 {
    fun solution(n: Int): Int {
        // at each step we discard half of the coins, hence the expected number of times is log2(N)
        return Math.ceil(Math.log(n.toDouble()) / Math.log(2.0)).toInt()
    }
}