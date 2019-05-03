package com.formichelli.dailycodingproblem.util

object Utils {
    fun prettyPrint(intArray: IntArray) = intArray.toList().toString()
    fun <T> prettyPrint(array: Array<T>) = array.toList().toString()
    fun <T> prettyPrint(matrix: Array<Array<T>>) = matrix.joinToString("\n") { prettyPrint(it) }
    fun prettyPrint(intMatrix: Array<IntArray>) = intMatrix.joinToString("\n") { prettyPrint(it) }
    fun prettyPrint(charMatrix: Array<CharArray>) = charMatrix.joinToString("\n") { prettyPrint(it) }
    fun prettyPrint(charArray: CharArray) = charArray.toList().toString()
    fun minOf(vararg numbers: Int) = numbers.min() ?: Int.MAX_VALUE
    fun findComplementInBST(root: TreeNode<Int>?, k: Int, node: TreeNode<Int>): TreeNode<Int>? {
        if (root == null) {
            return null
        }

        val target = k - node.value
        return when {
            root != node && root.value == target -> root
            root.value < target -> findComplementInBST(root.right, k, node)
            else -> findComplementInBST(root.left, k, node)
        }
    }
}