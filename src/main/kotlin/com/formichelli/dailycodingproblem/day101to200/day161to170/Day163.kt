package com.formichelli.dailycodingproblem.day101to200.day161to170

import java.util.*

/*
Given an arithmetic expression in Reverse Polish Notation, write a program to evaluate it.

The expression is given as a list of numbers and operands. For example: [5, 3, '+'] should return 5 + 3 = 8.

For example, [15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-'] should return 5, since it is equivalent to ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1)) = 5.

You can assume the given expression is always valid.
*/
object Day163 {
    fun solution(expression: List<String>): Int {
        val values = Stack<Int>()
        for (element in expression) {
            when (element) {
                "+" -> {
                    val secondOperand = values.pop()
                    val firstOperand = values.pop()
                    values.push(firstOperand + secondOperand)
                }
                "-" -> {
                    val secondOperand = values.pop()
                    val firstOperand = values.pop()
                    values.push(firstOperand - secondOperand)
                }
                "*" -> {
                    val secondOperand = values.pop()
                    val firstOperand = values.pop()
                    values.push(firstOperand * secondOperand)
                }
                "/" -> {
                    val secondOperand = values.pop()
                    val firstOperand = values.pop()
                    values.push(firstOperand / secondOperand)
                }
                else -> {
                    values.push(element.toInt())
                }
            }
        }

        return values.pop()
    }
}