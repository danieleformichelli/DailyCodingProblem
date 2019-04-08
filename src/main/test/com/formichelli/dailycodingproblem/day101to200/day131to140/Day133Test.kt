package com.formichelli.dailycodingproblem.day101to200.day131to140

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day133Test(private val result: Int?, private val node: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            /*
               10
              /  \
             5    30
                 /  \
               22    35
                 \
                  25
             */
            val ten = TreeNode(10)
            val five = TreeNode(5)
            val thirty = TreeNode(30)
            val twentyTwo = TreeNode(22)
            val twentyFive = TreeNode(25)
            val thirtyFive = TreeNode(35)

            ten.left = five
            ten.right = thirty
            thirty.left = twentyTwo
            twentyTwo.right = twentyFive
            thirty.right = thirtyFive

            return listOf(
                    arrayOf<Any?>(22, ten),
                    arrayOf<Any?>(10, five),
                    arrayOf<Any?>(35, thirty),
                    arrayOf<Any?>(25, twentyTwo),
                    arrayOf<Any?>(30, twentyFive),
                    arrayOf<Any?>(null, thirtyFive))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Next bigger element after ${node.value} is $result", result, Day133.solution(node))
    }
}