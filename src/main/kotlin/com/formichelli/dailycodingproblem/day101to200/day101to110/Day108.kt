package com.formichelli.dailycodingproblem.day101to200.day101to110

/*
Given two strings A and B, return whether or not A can be shifted some number of times to get B.

For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
*/
object Day108 {
    fun solution(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }

        val strLen = A.length

        var found = true
        for (i in 0 until strLen) {
            found = true
            for (j in 0 until strLen) {
                if (A[j] != B[(i + j) % strLen]) {
                    found = false
                    break
                }
            }

            if (found) {
                break
            }
        }

        return found
    }
}