package com.formichelli.dailycodingproblem.day31to40

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day36Test(private val result: Int, private val binaryTree: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val treeOne = TreeNode(10)
            treeOne.left = TreeNode(5)
            treeOne.left?.right = TreeNode(8)

            val treeTwo = TreeNode(10)
            treeTwo.left = TreeNode(5)
            treeTwo.left?.left = TreeNode(4)

            val treeThree = TreeNode(10)
            treeThree.right = TreeNode(20)
            treeThree.right?.right = TreeNode(30)
            treeThree.right?.right?.right = TreeNode(40)

            return listOf(
                    arrayOf(8, treeOne),
                    arrayOf(5, treeTwo),
                    arrayOf(30, treeThree))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Second biggest element of tree should be $result", result, Day36.solution(binaryTree))
    }
}