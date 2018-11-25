package com.formichelli.dailycodingproblem.day1to100.day1to100.day1to10

/*
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
Implement car and cdr.
*/
object Day5 {
    fun cons(a: Int, b: Int) : ((a: Int, b: Int) -> Int) -> Int {
        return {
            it(a, b)
        }
    }

    fun car(pair: ((a: Int, b: Int) -> Int) -> Int) : Int = pair { a: Int, _: Int -> a }

    fun cdr(pair: ((a: Int, b: Int) -> Int) -> Int) : Int = pair { _: Int, b: Int -> b }
}
