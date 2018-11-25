package com.formichelli.dailycodingproblem.day1to100.day91to100

/*
What does the below code snippet print out? How can we fix the anonymous functions to behave as we'd expect?

functions = []
for i in range(10):
    functions.append(lambda : i)

for f in functions:
    print(f())
*/
object Day91 {
    fun solution(n: Int): List<Int> {
        val f = (1..n).map { it -> { it } }.toList()

        val ret = ArrayList<Int>()
        f.forEach {
            ret.add(it())
        }

        return ret
    }
}
