package com.formichelli.dailycodingproblem.day1to10

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day8Test(private val result: Int, private val head: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val firstTree = TreeNode(0)
            firstTree.left = TreeNode(1)
            firstTree.right = TreeNode(0)
            firstTree.right!!.left = TreeNode(1)
            firstTree.right!!.left!!.left = TreeNode(1)
            firstTree.right!!.left!!.right = TreeNode(1)
            firstTree.right!!.right = TreeNode(0)

            val secondTree = TreeNode(0)
            secondTree.left = TreeNode(1)
            secondTree.right = TreeNode(0)
            secondTree.right!!.left = TreeNode(1)
            secondTree.right!!.left!!.left = TreeNode(1)
            secondTree.right!!.left!!.right = TreeNode(1)
            secondTree.right!!.right = TreeNode(0)
            secondTree.right!!.right!!.left = TreeNode(0)
            secondTree.right!!.right!!.right = TreeNode(1)

            val thirdTree = TreeNode(0)
            thirdTree.left = TreeNode(1)
            thirdTree.right = TreeNode(0)
            thirdTree.right!!.left = TreeNode(1)
            thirdTree.right!!.left!!.left = TreeNode(1)
            thirdTree.right!!.left!!.right = TreeNode(1)
            thirdTree.right!!.right = TreeNode(0)
            thirdTree.right!!.right!!.left = TreeNode(0)
            thirdTree.right!!.right!!.right = TreeNode(0)

            return listOf(
                    arrayOf(5, firstTree),
                    arrayOf(6, secondTree),
                    arrayOf(7, thirdTree)
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s contains %d unival trees", Day3.serializeTree(head), result), result, Day8.solution(head))
    }
}