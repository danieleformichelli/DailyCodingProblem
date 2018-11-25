package com.formichelli.dailycodingproblem.day1to100.day31to40

/*
Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
*/
object Day39 {
    fun solution(liveCells: Set<Pair<Int, Int>>, steps: Int): Set<Pair<Int, Int>> {
        val liveCellsBoard = HashMap<Int, MutableMap<Int, Int>>()
        val liveNeighboursBoard = HashMap<Int, MutableMap<Int, Int>>()

        // initialize boards
        liveCells.forEach {
            cellBornsOrDies(liveCellsBoard, liveNeighboursBoard, it, true)
        }

        // perform steps
        for (i in 0 until steps) {
            performStep(liveCellsBoard, liveNeighboursBoard)

            if (liveCellsBoard.isEmpty()) {
                return setOf()
            }
        }

        val liveCellsResult = mutableSetOf<Pair<Int, Int>>()
        liveCellsBoard.forEach {
            val x = it.key
            it.value.forEach {
                val y = it.key
                liveCellsResult.add(Pair(x, y))
            }
        }

        return liveCellsResult
    }

    private fun cellBornsOrDies(liveCellsBoard: HashMap<Int, MutableMap<Int, Int>>, liveNeighboursBoard: HashMap<Int, MutableMap<Int, Int>>, cellToBornOrDie: Pair<Int, Int>, bornsOrdDies: Boolean) {
        val neighboursIncrement: Int
        if (bornsOrdDies) {
            neighboursIncrement = 1
            setBoardValue(liveCellsBoard, cellToBornOrDie.first, cellToBornOrDie.second, 1)
        } else {
            neighboursIncrement = -1
            setBoardValue(liveCellsBoard, cellToBornOrDie.first, cellToBornOrDie.second, 0)
        }

        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first - 1, cellToBornOrDie.second - 1, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first - 1, cellToBornOrDie.second, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first - 1, cellToBornOrDie.second + 1, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first, cellToBornOrDie.second - 1, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first, cellToBornOrDie.second + 1, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first + 1, cellToBornOrDie.second - 1, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first + 1, cellToBornOrDie.second, neighboursIncrement)
        changeBoardValue(liveNeighboursBoard, cellToBornOrDie.first + 1, cellToBornOrDie.second + 1, neighboursIncrement)
    }

    private fun getBoardValue(board: MutableMap<Int, MutableMap<Int, Int>>, x: Int, y: Int) = board.computeIfAbsent(x) { _: Int -> HashMap() }[y]
            ?: 0

    private fun setBoardValue(board: MutableMap<Int, MutableMap<Int, Int>>, x: Int, y: Int, value: Int) {
        if (value != 0) {
            board.computeIfAbsent(x) { _: Int -> HashMap() }[y] = value
        } else {
            val boardXCells = board[x]
            if (boardXCells != null) {
                boardXCells.remove(y)
                if (boardXCells.isEmpty()) {
                    board.remove(x)
                }
            }
        }

    }

    private fun changeBoardValue(board: MutableMap<Int, MutableMap<Int, Int>>, x: Int, y: Int, valueDiff: Int) {
        setBoardValue(board, x, y, getBoardValue(board, x, y) + valueDiff)
    }

    /*
    Any live cell with less than two live neighbours dies.
    Any live cell with two or three live neighbours remains living.
    Any live cell with more than three live neighbours dies.
    Any dead cell with exactly three live neighbours becomes a live cell.
    */
    private fun performStep(liveCellsBoard: HashMap<Int, MutableMap<Int, Int>>, liveNeighboursBoard: HashMap<Int, MutableMap<Int, Int>>) {
        val cellsToBorn = liveNeighboursBoard.map {
            val x = it.key
            it.value.filter {
                // live cells will be processed later
                val y = it.key
                !isAlive(liveCellsBoard, x, y)
            }.filter {
                // Any dead cell with exactly three live neighbours becomes a live cell.
                val neighboursCount = it.value
                neighboursCount == 3
            }.map {
                val y = it.key
                Pair(x, y)
            }.toSet()
        }.flatten()

        val cellsToDie = liveCellsBoard.map {
            val x = it.key
            it.value.filter {
                // Any live cell with less than two live neighbours dies.
                // Any live cell with more than three live neighbours dies.
                val y = it.key
                val neighboursCount = getBoardValue(liveNeighboursBoard, x, y)
                neighboursCount < 2 || neighboursCount > 3
            }.map {
                val y = it.key
                Pair(x, y)
            }.toSet()
        }.flatten()

        cellsToBorn.forEach {
            cellBornsOrDies(liveCellsBoard, liveNeighboursBoard, it, true)
        }

        cellsToDie.forEach {
            cellBornsOrDies(liveCellsBoard, liveNeighboursBoard, it, false)
        }
    }

    private fun isAlive(liveCellsBoard: Map<Int, MutableMap<Int, Int>>, x: Int, y: Int): Boolean {
        val cellsAtX = liveCellsBoard[x] ?: return false

        return cellsAtX[y] != null
    }
}
