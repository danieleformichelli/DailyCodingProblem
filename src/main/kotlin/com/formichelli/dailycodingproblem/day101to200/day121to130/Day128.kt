package com.formichelli.dailycodingproblem.day101to200.day121to130

import java.util.*

/*
The Tower of Hanoi is a puzzle game with three rods and n disks, each a different size.

All the disks start off on the first rod in a stack. They are ordered by size, with the largest disk on the bottom and the smallest one at the top.

The goal of this puzzle is to move all the disks from the first rod to the last rod while following these rules:

You can only move one disk at a time.
A move consists of taking the uppermost disk from one of the stacks and placing it on top of another stack.
You cannot place a larger disk on top of a smaller disk.
Write a function that prints out all the steps necessary to complete the Tower of Hanoi. You should assume that the rods are numbered, with the first rod being 1, the second (auxiliary) rod being 2, and the last (goal) rod being 3.

For example, with n = 3, we can do this in 7 moves:

Move 1 to 3
Move 1 to 2
Move 3 to 2
Move 1 to 3
Move 2 to 1
Move 2 to 3
Move 1 to 3
*/
object Day128 {
    private class HanoiTower(private val n: Int, val id: Int, fill: Boolean = false) {
        val disks: Stack<Int> = Stack()

        init {
            if (fill) {
                for (i in n downTo 1) {
                    disks.push(i)
                }
            }
        }

        fun pushDisk(diskSize: Int): Boolean {
            if (disks.size == n || (!disks.isEmpty() && disks.peek() >= diskSize)) {
                return false
            }

            disks.push(diskSize)
            return true
        }

        fun popDisk(): Int {
            return if (!disks.isEmpty()) {
                disks.pop()
            } else {
                -1
            }
        }
    }

    fun solution(n: Int): List<Pair<Int, Int>> {
        val towers = Array(3) { HanoiTower(n, it + 1, it == 0) }

        val result = ArrayList<Pair<Int, Int>>()
        moveDisks(n, towers[0], towers[2], towers[1], result)
        return result
    }

    private fun moveDisks(n: Int, from: HanoiTower, to: HanoiTower, through: HanoiTower, result: ArrayList<Pair<Int, Int>>) {
        if (n == 0) {
            return
        }

        // move the top n-1 disks to through using to as buffer
        moveDisks(n - 1, from, through, to, result)

        // move the bottom disk to to
        result.add(Pair(from.id, to.id))
        to.pushDisk(from.popDisk())

        // move the remaining n-1 disks from through to to using from as buffer
        moveDisks(n - 1, through, to, from, result)
    }
}