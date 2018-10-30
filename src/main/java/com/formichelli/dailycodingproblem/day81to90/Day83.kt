package com.formichelli.dailycodingproblem.day81to90

import java.util.*

/*
nvert a binary tree.

For example, given the following tree:

    a
   / \
  b   c
 / \  /
d   e f
should become:

  a
 / \
 c  b
 \  / \
  f e  d
*/
object Day83 {
    private val rand = Random()
    private fun rand7() = rand.nextInt(7) + 1

    fun solution(): Int {
        var rand5: Int
        do {
            rand5 = rand7()
        } while (rand5 !in 1..5)

        return rand5
    }
}