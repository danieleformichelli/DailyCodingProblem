package com.formichelli.dailycodingproblem

/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/
object Day7 {
    fun solution(message: String): Int {
        val dictionary = ArrayList<String>()
        for (i in 1..26) {
            dictionary.add(i.toString())
        }

        return countFromIndex(message, 0, dictionary)
    }

    private fun countFromIndex(message: String, startIndex: Int, dictionary: List<String>): Int {
        if (message.length == startIndex) return 1
        var count = 0
        for (word in dictionary) {
            if (message.startsWith(word, startIndex)) {
                count += countFromIndex(message, startIndex + word.length, dictionary)
            }
        }
        return count
    }
}