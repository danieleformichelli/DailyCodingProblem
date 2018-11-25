package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

/*
Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
*/
object Day29 {
    fun encode(string: String): String {
        if (string.isEmpty()) {
            return ""
        }

        val encodedString = StringBuilder()
        var currentChar = string[0]
        var currentCharCount = 0
        string.forEach {
            if (it != currentChar) {
                encodedString.append(currentCharCount).append(currentChar)
                currentChar = it
                currentCharCount = 1
            } else {
                ++currentCharCount
            }
        }

        encodedString.append(currentCharCount).append(currentChar)
        return encodedString.toString()
    }

    fun decode(string: String): String {
        val decodedString = StringBuilder()
        var currentNumber = 0
        string.forEach {
            val digit = it - '0'
            if (digit in 1..9) {
                // digit
                currentNumber = currentNumber * 10 + digit
            } else {
                // non digit
                decodedString.append(it.toString().repeat(currentNumber))
                currentNumber = 0
            }
        }

        return decodedString.toString()
    }
}
