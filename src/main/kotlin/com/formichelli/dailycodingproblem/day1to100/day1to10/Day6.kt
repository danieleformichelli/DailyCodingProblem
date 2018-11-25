package com.formichelli.dailycodingproblem.day1to100.day1to10

import java.util.concurrent.atomic.AtomicInteger

/*
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to getPointer and dereferencePointer functions that converts between nodes and memory addresses.
*/
object Day6 {
    // To allow testing, simulate pointers by assigning incremental integers to each object and putting them into a map
    val addressProvider = AtomicInteger(0)

    data class XorNode<T>(val value: T, var both: Int) {
        private val address = addressProvider.incrementAndGet()

        fun address(): Int {
            return address
        }
    }

    private val nodesMap = HashMap<Int, XorNode<Int>>()
    private fun getPointer(node: XorNode<Int>) = node.address()
    private fun dereferencePointer(pointer: Int) = nodesMap[pointer]!!
    fun allocateNode(value: Int, both: Int): XorNode<Int> {
        val node = XorNode(value, both)
        nodesMap[node.address()] = node
        return node
    }

    fun add(head: XorNode<Int>, value: Int) {
        var prevNodePointer = 0
        var currentNode = head
        while ((currentNode.both xor prevNodePointer) != 0) {
            val nextNodePointer = currentNode.both xor prevNodePointer
            prevNodePointer = getPointer(currentNode)
            currentNode = dereferencePointer(nextNodePointer)
        }

        val newNode = allocateNode(value, getPointer(currentNode))
        currentNode.both = currentNode.both xor getPointer(newNode)
    }

    fun get(head: XorNode<Int>, index: Int): Int {
        var prevNodePointer = 0
        var currentNode = head
        for (i in 0 until index) {
            val nextNodePointer = currentNode.both xor prevNodePointer
            if (nextNodePointer == 0) {
                throw IndexOutOfBoundsException()
            }
            prevNodePointer = getPointer(currentNode)
            currentNode = dereferencePointer(nextNodePointer)
        }

        return currentNode.value
    }
}
