package com.formichelli.dailycodingproblem.day11to20

/*
You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
You should be as efficient with time and space as possible.
*/
object Day16 {
    class OrderLog(private val N: Int) {
        private val orderIds = Array(N) { "" }
        private var nextOrderIndex = 0

        fun record(orderId: String) {
            orderIds[nextOrderIndex] = orderId
            if (++nextOrderIndex == N)
                nextOrderIndex = 0
        }

        fun getLast(i: Int): String {
            return if (nextOrderIndex >= i)
                orderIds[nextOrderIndex - i]
            else
                orderIds[N - (i - nextOrderIndex)]
        }
    }
}
