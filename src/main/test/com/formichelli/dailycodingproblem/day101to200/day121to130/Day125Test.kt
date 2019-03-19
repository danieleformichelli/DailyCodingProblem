package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day125Test(private val result: Pair<Int, Int>, private val root: TreeNode<Int>, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val root = TreeNode(10)
            root.left = TreeNode(5)
            root.right = TreeNode(15)
            root.right?.left = TreeNode(11)
            root.right?.right = TreeNode(15)

            return listOf<Array<Any?>>(
                    arrayOf(Pair(5, 15), root, 20),
                    arrayOf(Pair(15, 15), root, 30),
                    arrayOf(Pair(10, 15), root, 25))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$k can be obtained as the sum of ${result.first} and ${result.second}", result, Day125.solution(root, k))
    }
}