package com.formichelli.dailycodingproblem.day1to100.day1to100.day51to60

import kotlin.math.roundToInt

/*
Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.

Implement an efficient sudoku solver.
*/
object Day54 {
    fun solution(table: Array<IntArray>) {
        val sudokuSize = table.size
        val squareSize = squareSize(table)

        val rowHasNumber = Array(sudokuSize) { BooleanArray(sudokuSize) }
        val columnHasNumber = Array(sudokuSize) { BooleanArray(sudokuSize) }
        val squareHasNumber = Array(squareSize) { Array(squareSize) { BooleanArray(sudokuSize) } }

        for (row in 0 until sudokuSize) {
            for (column in 0 until sudokuSize) {
                val cellValue = table[row][column]

                if (cellValue != 0) {
                    if (!setNumber(table, row, column, cellValue, rowHasNumber, columnHasNumber, squareHasNumber)) {
                        throw IllegalArgumentException("Invalid input table, $cellValue cannot be placed at ($row,$column)")
                    }
                }
            }
        }

        solutionHelper(table, 0, 0, rowHasNumber, columnHasNumber, squareHasNumber)
    }

    private fun squareSize(table: Array<IntArray>) = Math.sqrt(table.size.toDouble()).roundToInt()

    private fun solutionHelper(table: Array<IntArray>, row: Int, column: Int, rowHasNumber: Array<BooleanArray>, columnHasNumber: Array<BooleanArray>, squareHasNumber: Array<Array<BooleanArray>>): Boolean {
        if (row == table.size) {
            return true
        }

        val nextRow: Int
        val nextColumn: Int

        if (column != table.size - 1) {
            nextColumn = column + 1
            nextRow = row
        } else {
            nextColumn = 0
            nextRow = row + 1
        }

        if (table[row][column] != 0) {
            if (solutionHelper(table, nextRow, nextColumn, rowHasNumber, columnHasNumber, squareHasNumber)) {
                return true
            }
        } else {
            for (number in 1..table.size) {
                if (setNumber(table, row, column, number, rowHasNumber, columnHasNumber, squareHasNumber)) {
                    if (solutionHelper(table, nextRow, nextColumn, rowHasNumber, columnHasNumber, squareHasNumber)) {
                        return true
                    }
                    unsetNumber(table, row, column, rowHasNumber, columnHasNumber, squareHasNumber)
                }
            }
        }

        return false
    }

    private fun setNumber(table: Array<IntArray>, row: Int, column: Int, number: Int, rowHasNumber: Array<BooleanArray>, columnHasNumber: Array<BooleanArray>, squareHasNumber: Array<Array<BooleanArray>>): Boolean {
        val squareSize = Math.sqrt(table.size.toDouble()).roundToInt()

        val numbersInRow = rowHasNumber[row]
        val numbersInColumn = columnHasNumber[column]
        val numbersInSquare = squareHasNumber[row / squareSize][column / squareSize]
        val numberIndex = number - 1
        when {
            (table[row][column] != 0 && table[row][column] != number) || numbersInRow[numberIndex] || numbersInColumn[numberIndex] || numbersInSquare[numberIndex] -> {
                return false
            }
            else -> {
                numbersInRow[numberIndex] = true
                numbersInColumn[numberIndex] = true
                numbersInSquare[numberIndex] = true
            }
        }

        table[row][column] = number
        return true
    }

    private fun unsetNumber(table: Array<IntArray>, row: Int, column: Int, rowHasNumber: Array<BooleanArray>, columnHasNumber: Array<BooleanArray>, squareHasNumber: Array<Array<BooleanArray>>) {
        val squareSize = squareSize(table)
        val number = table[row][column]
        val numberIndex = number - 1
        table[row][column] = 0
        rowHasNumber[row][numberIndex] = false
        columnHasNumber[column][numberIndex] = false
        squareHasNumber[row / squareSize][column / squareSize][numberIndex] = false
    }
}
