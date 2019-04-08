package com.formichelli.dailycodingproblem.day101to200.day131to140

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day135Test(private val result: Int, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            /*
              10
             /  \
            5    5
             \     \
               2    1
                   /
                 -1
            */
            val root = TreeNode(10)
            val leftFive = TreeNode(5)
            val rightFive = TreeNode(5)
            val two = TreeNode(2)
            val one = TreeNode(1)
            val minusOne = TreeNode(-1)

            root.left = leftFive
            root.right = rightFive
            leftFive.right = two
            rightFive.right = one
            one.left = minusOne

            return listOf(
                    arrayOf<Any?>(15, root))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Minimum path sum from the root to a leaf is $result", result, Day135.solution(root))
    }
}