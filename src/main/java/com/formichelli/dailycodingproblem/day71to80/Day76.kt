package com.formichelli.dailycodingproblem.day71to80

/*
You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.

For example, given the following table:

cba
daf
ghi
This is not ordered because of the a in the center. We can remove the second column to make it ordered:

ca
df
gi
So your function should return 1, since we only needed to remove 1 column.

As another example, given the following table:

abcdef
Your function should return 0, since the rows are already ordered (there's only one row).

As another example, given the following table:

zyx
wvu
tsr
Your function should return 3, since we would need to remove all the columns to order it.
*/
object Day76 {
    fun solution(letters: Array<CharArray>): Int {
        if (letters.isEmpty()) {
            return 0
        }

        val columnsCount = letters[0].size
        var columnsToBeRemoved = 0
        var lastLetter = 'a'
        for (column in 0 until columnsCount) {
            for (row in 0 until letters.size) {
                if (letters[row][column] < lastLetter) {
                    ++columnsToBeRemoved
                    break
                } else {
                    lastLetter = letters[row][column]
                }
            }
            lastLetter = 'a'
        }

        return columnsToBeRemoved
    }
}
