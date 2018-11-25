package com.formichelli.dailycodingproblem.day1to100.day21to30

import java.util.*

/*
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
*/
object Day27 {
    private val OPENING = listOf('(', '[', '{')
    private val CLOSING = listOf(')', ']', '}')

    fun solution(string: String): Boolean {
        val stack = Stack<Char>()
        string.forEach {
            when {
                OPENING.contains(it) -> stack.push(it)
                CLOSING.contains(it) -> {
                    val indexOfOpening = OPENING.indexOf(stack.pop())
                    if (it != CLOSING[indexOfOpening]) {
                        return false
                    }
                }
                else -> throw IllegalArgumentException("Illegal character: $it")
            }
        }

        return stack.empty()
    }
}
