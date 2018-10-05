package com.formichelli.dailycodingproblem.day51to60

import com.formichelli.dailycodingproblem.util.ListNode

/*
Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
get(key): gets the value at key. If no such key exists, return null.
Each operation should run in O(1) time.
*/
object Day52 {
    class LRUCache(private val n: Int) {
        private var first: ListNode<Pair<Int, Int>>? = null
        private var last: ListNode<Pair<Int, Int>>? = null
        private val nodeMap = HashMap<Int, ListNode<Pair<Int, Int>>>()

        fun set(key: Int, value: Int) {
            val newNode = ListNode(Pair(key, value), first)
            first = newNode
            if (last == null) {
                last = first
            }

            if (nodeMap.size == n) {
                // remove last element from cache
                nodeMap.remove(last?.value?.first)
                last?.prev?.next = null
                last = last?.prev
            }

            nodeMap[key] = newNode
        }

        fun get(key: Int): Int? {
            val returnNode = nodeMap[key] ?: return null
            if (returnNode != first) {
                // move node to top of list
                returnNode.next?.prev = returnNode.prev
                returnNode.prev?.next = returnNode.next
                returnNode.prev = null
                returnNode.next = first
                first = returnNode
            }

            return returnNode.value.second
        }
    }
}
