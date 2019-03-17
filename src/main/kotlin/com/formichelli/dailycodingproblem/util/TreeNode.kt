package com.formichelli.dailycodingproblem.util

open class TreeNode<T>(val value: T) {
    open var left: TreeNode<T>? = null
        set(value) {
            field = value
            value?.parent = this
        }
    open var right: TreeNode<T>? = null
        set(value) {
            field = value
            value?.parent = this
        }
    var parent: TreeNode<T>? = null
        internal set(value) {
            field = value
        }

    override fun equals(other: Any?): Boolean {
        if (other !is TreeNode<*>)
            return false

        if (value?.equals(other.value) != true)
            return false

        if (left == null && other.left != null)
            return false

        if (left != null && left?.equals(other.left) != true)
            return false

        if (right == null && other.right != null)
            return false

        if (right != null && right?.equals(other.right) != true)
            return false

        return true
    }

    override fun hashCode(): Int = (value?.hashCode() ?: 0) + (left?.hashCode() ?: 0) + (right?.hashCode() ?: 0)

    override fun toString() = "($value,$left,$right)"
}