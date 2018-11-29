package com.formichelli.dailycodingproblem.day101to200.day101to110

/*
Given a function f, and N return a debounced f of N milliseconds.

That is, as long as the debounced f continues to be invoked, f itself will not be called for N milliseconds.
*/
object Day105 {
    fun solution(f: () -> Any, N: Int): () -> Any {
        var timeOutExpires = System.currentTimeMillis()

        return {
            val currentTime = System.currentTimeMillis()
            val shouldBeCalled = currentTime > timeOutExpires
            timeOutExpires = currentTime + N
            if (shouldBeCalled) {
                f()
            }
        }
    }
}