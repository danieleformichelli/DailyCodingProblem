package com.formichelli.dailycodingproblem.day201to300.day211to220

/*
Connect 4 is a game where opponents take turns dropping red or black discs into a 7 x 6 vertically suspended grid. The game ends either when one player creates a line of four consecutive discs of their color (horizontally, vertically, or diagonally), or when there are no more spots left in the grid.

Design and implement Connect 4.
*/
object Day219 {
    enum class Color {
        Red, Black
    }

    enum class PutResult {
        WIN, DRAW, PUT, ERROR
    }

    class Connect4 {
        fun put(index: Int, color: Color): PutResult {
            TODO("not implemented")
        }
    }
}