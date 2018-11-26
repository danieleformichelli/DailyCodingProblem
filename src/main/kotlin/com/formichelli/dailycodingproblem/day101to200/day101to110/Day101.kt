package com.formichelli.dailycodingproblem.day101to200.day101to110

/*
Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.

A solution will always exist. See Goldbach’s conjecture.

Example:

Input: 4
Output: 2 + 2 = 4
If there are more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then

[a, b] < [c, d]
If a < c OR a==c AND b < d.
*/
object Day101 {
    fun solution(number: Int): Pair<Int, Int> {
        val primes = Array<Boolean?>(number + 1) { true }
        primes[0] = false
        primes[1] = false

        for (i in 2..Math.floor(Math.sqrt(number.toDouble())).toInt()) {
            if (primes[i] == true) {
                var mul = i * 2
                while (mul <= number) {
                    primes[mul] = false
                    mul += i
                }
            }
        }

        for (firstPrime in 0..number) {
            if (primes[firstPrime] == true) {
                val secondPrime = number - firstPrime
                if (primes[secondPrime] == true) {
                    return Pair(firstPrime, secondPrime)
                }
            }
        }

        throw Exception("Can never happen")
    }
}