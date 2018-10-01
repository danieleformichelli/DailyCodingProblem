package com.formichelli.dailycodingproblem.day_11_20

import java.util.*

/*
The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
*/
object Day14 {
    fun solution(): Double {
        val random = Random()
        var inCount = 0
        val totCount = 10000000
        for (i in 0 until totCount) {
            val x = random.nextDouble()
            val y = random.nextDouble()
            if (x * x + y * y < 1) {
                ++inCount
            }
        }

        return 4 * inCount / totCount.toDouble()
    }
}
